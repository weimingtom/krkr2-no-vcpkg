/****************************************************************************
Copyright (c) 2010-2012 cocos2d-x.org
Copyright (c) 2013-2016 Chukong Technologies Inc.
Copyright (c) 2017-2018 Xiamen Yaji Software Co., Ltd.

http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 ****************************************************************************/
package org.cocos2dx.lib;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.content.res.AssetFileDescriptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Cocos2dxSound {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final String TAG = "Cocos2dxSound";

    // ===========================================================
    // Fields
    // ===========================================================

    private final Context mContext;
    private SoundPool mSoundPool;
    private float mLeftVolume;
    private float mRightVolume;
    private boolean mIsAudioFocus = true;

    // sound path and stream ids map
    // a file may be played many times at the same time
    // so there is an array map to a file path
    private final HashMap<String, ArrayList<Integer>> mPathStreamIDsMap = new HashMap<String, ArrayList<Integer>>();
    // A lock for mPathStreamIDsMap operation to keep mPathStreamIDsMap being visited in only one thread at a time.
    private final Object mLockPathStreamIDsMap = new Object();

    private final HashMap<String, Integer> mPathSoundIDMap = new HashMap<String, Integer>();

    // Key: SoundID, Value: SoundInfoForLoadedCompleted
    private ConcurrentHashMap<Integer, SoundInfoForLoadedCompleted> mPlayWhenLoadedEffects =
            new ConcurrentHashMap<Integer, SoundInfoForLoadedCompleted>();

    private static final int MAX_SIMULTANEOUS_STREAMS_DEFAULT = 5;
    private static final int MAX_SIMULTANEOUS_STREAMS_I9100 = 3;
    private static final float SOUND_RATE = 1.0f;
    private static final int SOUND_PRIORITY = 1;
    private static final int SOUND_QUALITY = 5;

    private final static int INVALID_SOUND_ID = -1;
    private final static int INVALID_STREAM_ID = -1;

    // ===========================================================
    // Constructors
    // ===========================================================

    public Cocos2dxSound(final Context context) {
        this.mContext = context;

        this.initData();
    }

    private void initData() {
        if (Cocos2dxHelper.getDeviceModel().contains("GT-I9100")) {
            this.mSoundPool = new SoundPool(Cocos2dxSound.MAX_SIMULTANEOUS_STREAMS_I9100, AudioManager.STREAM_MUSIC, Cocos2dxSound.SOUND_QUALITY);
        }
        else {
            this.mSoundPool = new SoundPool(Cocos2dxSound.MAX_SIMULTANEOUS_STREAMS_DEFAULT, AudioManager.STREAM_MUSIC, Cocos2dxSound.SOUND_QUALITY);
        }
        
        this.mSoundPool.setOnLoadCompleteListener(new OnLoadCompletedListener());

        this.mLeftVolume = 0.5f;
        this.mRightVolume = 0.5f;
    }

    /*
     * @brief Preload a compressed audio file.
     * @param path The path of the effect file.
     */
    public int preloadEffect(final String path) {
        Integer soundID = this.mPathSoundIDMap.get(path);

        if (soundID == null) {
            soundID = this.createSoundIDFromAsset(path);
            // save value just in case if file is really loaded
            if (soundID != Cocos2dxSound.INVALID_SOUND_ID) {
                this.mPathSoundIDMap.put(path, soundID);
            }
        }

        return soundID;
    }

    
    /*
     * @brief Unload the preloaded effect from internal buffer.
     * @param path The path of the effect file.
     */
    public void unloadEffect(final String path) {
        synchronized (mLockPathStreamIDsMap) {
            // stop effects
            final ArrayList<Integer> streamIDs = this.mPathStreamIDsMap.get(path);
            if (streamIDs != null) {
                for (final Integer steamID : streamIDs) {
                    this.mSoundPool.stop(steamID);
                }
            }
            this.mPathStreamIDsMap.remove(path);
        }

        // unload effect
        final Integer soundID = this.mPathSoundIDMap.get(path);
        if (soundID != null) {
            this.mSoundPool.unload(soundID);
            this.mPathSoundIDMap.remove(path);
        }
    }

    private static final int LOAD_TIME_OUT = 500;

    /*
     * @brief Play sound effect with a path, pitch, pan, and gain.
     * @param path The path of the effect file.
     * @param loop Determines whether to loop the effect playing or not.
     * @param pitch Fequency, normal value is 1.0. will also change effect play time.
     * @param pan Stereo effect, in the range of [-1..1] where -1 enables only left channel.
     * @param gain Volume, in the range of [0..1]. The normal value is 1.
     * @return Value of streamID from Java int method if it can preload effect; otherwise -1.
     */
    public int playEffect(final String path, final boolean loop, float pitch, float pan, float gain){
        Integer soundID = this.mPathSoundIDMap.get(path);
        int streamID = Cocos2dxSound.INVALID_STREAM_ID;

        if (soundID != null) {
            // parameters; pan = -1 for left channel, 1 for right channel, 0 for both channels

            // play sound
            streamID = this.doPlayEffect(path, soundID, loop, pitch, pan, gain);
        } else {
            // the effect is not prepared
            soundID = this.preloadEffect(path);
            if (soundID == Cocos2dxSound.INVALID_SOUND_ID) {
                // can not preload effect
                return Cocos2dxSound.INVALID_SOUND_ID;
            }

            SoundInfoForLoadedCompleted info = new SoundInfoForLoadedCompleted(path, loop, pitch, pan, gain);
            mPlayWhenLoadedEffects.putIfAbsent(soundID, info);

            synchronized(info) {
                try {
                    info.wait(LOAD_TIME_OUT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            streamID = info.effectID;
            mPlayWhenLoadedEffects.remove(soundID);
        }

        return streamID;
    }

    /*
     * @brief Stop playing sound effect.
     * @param streamID The return value of function playEffect.
     */
    public void stopEffect(final int steamID) {
        this.mSoundPool.stop(steamID);

        synchronized (mLockPathStreamIDsMap) {
            // remove record
            for (final String pPath : this.mPathStreamIDsMap.keySet()) {
                if (this.mPathStreamIDsMap.get(pPath).contains(steamID)) {
                    this.mPathStreamIDsMap.get(pPath).remove(this.mPathStreamIDsMap.get(pPath).indexOf(steamID));
                    break;
                }
            }
        }
    }

    /*
     * @brief Pause playing sound effect.
     * @param streamID The return value of function playEffect.
     */
    public void pauseEffect(final int steamID) {
        this.mSoundPool.pause(steamID);
    }

    /*
     * @brief Resume playing sound effect.
     * @param streamID The return value of function playEffect.
     */
    public void resumeEffect(final int steamID) {
        this.mSoundPool.resume(steamID);
    }

    /*
     * @brief Pause all playing sound effect.
     */
    public void pauseAllEffects() {
        synchronized (mLockPathStreamIDsMap) {
            if (!this.mPathStreamIDsMap.isEmpty()) {
                final Iterator<Entry<String, ArrayList<Integer>>> iter = this.mPathStreamIDsMap.entrySet().iterator();
                while (iter.hasNext()) {
                    final Entry<String, ArrayList<Integer>> entry = iter.next();
                    for (final int steamID : entry.getValue()) {
                        this.mSoundPool.pause(steamID);
                    }
                }
            }
        }
    }

    /*
     * @brief Resume all playing sound effects.
     */
    public void resumeAllEffects() {
        synchronized (mLockPathStreamIDsMap) {
            // can not only invoke SoundPool.autoResume() here, because
            // it only resumes all effects paused by pauseAllEffects()
            if (!this.mPathStreamIDsMap.isEmpty()) {
                final Iterator<Entry<String, ArrayList<Integer>>> iter = this.mPathStreamIDsMap.entrySet().iterator();
                while (iter.hasNext()) {
                    final Entry<String, ArrayList<Integer>> entry = iter.next();
                    for (final int steamID : entry.getValue()) {
                        this.mSoundPool.resume(steamID);
                    }
                }
            }
        }
    }

    /*
     * @brief Stop all playing sound effects.
     */
    public void stopAllEffects() {
        synchronized (mLockPathStreamIDsMap) {
            // stop effects
            if (!this.mPathStreamIDsMap.isEmpty()) {
                final Iterator<?> iter = this.mPathStreamIDsMap.entrySet().iterator();
                while (iter.hasNext()) {
                    final Map.Entry<String, ArrayList<Integer>> entry = (Map.Entry<String, ArrayList<Integer>>) iter.next();
                    for (final int steamID : entry.getValue()) {
                        this.mSoundPool.stop(steamID);
                    }
                }
            }

            // remove records
            this.mPathStreamIDsMap.clear();
        }
    }

    /*
     * @brief Get the volume of the effects.
     * @return the range of 0.0 as the minimum and 1.0 as the maximum.
     */
    public float getEffectsVolume() {
        return (this.mLeftVolume + this.mRightVolume) / 2;
    }

    /*
     * @brief Set the volume of sound effects.
     * @param volume must be range of 0.0 as the minimum and 1.0 as the maximum.
     */
    public void setEffectsVolume(float volume) {
        // volume should be in [0, 1.0]
        if (volume < 0) {
            volume = 0;
        }
        if (volume > 1) {
            volume = 1;
        }

        this.mLeftVolume = this.mRightVolume = volume;

        if (!mIsAudioFocus)
            return;

        setEffectsVolumeInternal(mLeftVolume, mRightVolume);
    }

    /*
     * @brief Set the volume of sound effects internal.
     * @param left Left volume that must be range of 0.0 as the minimum and 1.0 as the maximum.
     * @param right Right volume that must be range of 0.0 as the minimum and 1.0 as the maximum.
     */
    private void setEffectsVolumeInternal(float left, float right) {
        synchronized (mLockPathStreamIDsMap) {
            // change the volume of playing sounds
            if (!this.mPathStreamIDsMap.isEmpty()) {
                final Iterator<Entry<String, ArrayList<Integer>>> iter = this.mPathStreamIDsMap.entrySet().iterator();
                while (iter.hasNext()) {
                    final Entry<String, ArrayList<Integer>> entry = iter.next();
                    for (final int steamID : entry.getValue()) {
                        this.mSoundPool.setVolume(steamID, left, right);
                    }
                }
            }
        }
    }

    public void end() {
        this.mSoundPool.release();
        synchronized (mLockPathStreamIDsMap) {
            this.mPathStreamIDsMap.clear();
        }
        this.mPathSoundIDMap.clear();
        this.mPlayWhenLoadedEffects.clear();

        this.mLeftVolume = 0.5f;
        this.mRightVolume = 0.5f;

        this.initData();
    }

    private int createSoundIDFromAsset(final String path) {
        int soundID = Cocos2dxSound.INVALID_SOUND_ID;

        try {
            if (path.startsWith("/")) {
                soundID = this.mSoundPool.load(path, 0);
            } else {
//                if (Cocos2dxHelper.getObbFile() != null) {
//                    final AssetFileDescriptor assetFileDescriptor = Cocos2dxHelper.getObbFile().getAssetFileDescriptor(path);
//                    soundID = mSoundPool.load(assetFileDescriptor, 0);
//                } else {
                    soundID = this.mSoundPool.load(this.mContext.getAssets().openFd(path), 0);
//                }
            }
        } catch (final Exception e) {
            soundID = Cocos2dxSound.INVALID_SOUND_ID;
            Log.e(Cocos2dxSound.TAG, "error: " + e.getMessage(), e);
        }

        // mSoundPool.load returns 0 if something goes wrong, for example a file does not exist
        if (soundID == 0) {
            soundID = Cocos2dxSound.INVALID_SOUND_ID;
        }

        return soundID;
    }

    private float clamp(float value, float min, float max) {
        return Math.max(min, (Math.min(value, max)));
    }

    // Adds 'synchronized' keyword for doPlayeEffect since it's possible to be invoked in GL thread and main thread.
    // In Cocos2dxSound.playEffect, it's in GL thread.
    // In onLoadComplete callback, it's in main thread.
    private synchronized int doPlayEffect(final String path, final int soundId, final boolean loop, float pitch, float pan, float gain) {
        float leftVolume = this.mLeftVolume * gain * (1.0f - this.clamp(pan, 0.0f, 1.0f));
        float rightVolume = this.mRightVolume * gain * (1.0f - this.clamp(-pan, 0.0f, 1.0f));
        float soundRate = this.clamp(SOUND_RATE * pitch, 0.5f, 2.0f);

        // play sound
        int streamID = this.mSoundPool.play(soundId, this.clamp(leftVolume, 0.0f, 1.0f), this.clamp(rightVolume, 0.0f, 1.0f), Cocos2dxSound.SOUND_PRIORITY, loop ? -1 : 0, soundRate);

        synchronized (mLockPathStreamIDsMap) {
            // record stream id
            ArrayList<Integer> streamIDs = this.mPathStreamIDsMap.get(path);
            if (streamIDs == null) {
                streamIDs = new ArrayList<Integer>();
                this.mPathStreamIDsMap.put(path, streamIDs);
            }
            streamIDs.add(streamID);
        }

        return streamID;
    }

    public void onEnterBackground(){
        this.mSoundPool.autoPause();
    }

    public void onEnterForeground(){
        this.mSoundPool.autoResume();
    }

    /*
     * @brief Set audio focus.
     * @param isAudioFocus Determines whether to set audio focused or not.
     */
    void setAudioFocus(boolean isFocus) {
        mIsAudioFocus = isFocus;
        float leftVolume = mIsAudioFocus ? mLeftVolume : 0.0f;
        float rightVolume = mIsAudioFocus ? mRightVolume : 0.0f;

        setEffectsVolumeInternal(leftVolume, rightVolume);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    private class SoundInfoForLoadedCompleted {
        boolean isLoop;
        float pitch;
        float pan;
        float gain;
        String path;
        int effectID;

        SoundInfoForLoadedCompleted(String path, boolean isLoop, float pitch, float pan, float gain) {
            this.path = path;
            this.isLoop = isLoop;
            this.pitch = pitch;
            this.pan = pan;
            this.gain = gain;
            effectID = Cocos2dxSound.INVALID_SOUND_ID;
        }
    }

    public class OnLoadCompletedListener implements SoundPool.OnLoadCompleteListener {

        @Override
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            // This callback is in main thread.
            if (status == 0)
            {
                SoundInfoForLoadedCompleted info =  mPlayWhenLoadedEffects.get(sampleId);

                if (info != null) {
                    info.effectID = doPlayEffect(info.path, sampleId, info.isLoop, info.pitch, info.pan, info.gain);
                    synchronized (info) {
                        info.notifyAll();
                    }
                }
            }
        }
    }
}
