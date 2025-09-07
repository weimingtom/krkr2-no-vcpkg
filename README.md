# krkr2-no-vcpkg
[WIP and not recommended] build krkr2 kirikiroid2 vcpkg version without vcpkg, with apt install instead.  
Code base:  
https://github.com/2468785842/krkr2/tree/73e9bfe153d2261486fb0245fa31d97271cfef9f  

## Bugs
* Android: Exit/Save will cause loop and no response, krkr2-no-vcpkg_v19_android_exit_save_loop.7z  
* File manager UI scrolls not well

## TODO
* Port to msys2, cocos2d-x-2.2.6_msys_v1.7z, cocos2d-x-2.2.6_mingw.7z
* Linux build not tested
* Some code is changed to mine (see readme_android.txt, like core/environ/android/AndroidUtils.cpp and core/sound/win32/WaveMixer.cpp), not original code, need to be synchronized  
* https://github.com/weimingtom/krkr2-no-vcpkg/blob/master/src/core/environ/android/AndroidUtils.cpp  
* https://github.com/weimingtom/krkr2-no-vcpkg/blob/master/src/core/sound/win32/WaveMixer.cpp  
* Modify https://github.com/weimingtom/krkr2-no-vcpkg/blob/master/jni/main.cpp, include "../src/core/environ/cocos2d/AppDelegate.h"  
* Remove console.bat NDK_MODULE_PATH

## Recommended Development Environment for good audio music output 
* Xubuntu 20.04 desktop amd64, in VMWare or VirtualBox  
* Fedora 41 x86_64, in VirtualBox  

## For Xubuntu 20.04 and Xubuntu 25.04, desktop amd64, in VMWare (20.04 also support VirtualBox)  
* $ sudo apt update
* $ sudo apt install lftp gedit pkg-config make gcc g++ cmake
* $ sudo apt install libglew-dev libfreetype-dev libglfw3-dev libsdl2-dev libvorbis-dev libwebp-dev  libboost-locale-dev libfmt-dev libopencv-dev liblz4-dev libspdlog-dev libopenal-dev libgtk2.0-dev libarchive-dev libopusfile-dev libminizip-dev libjpeg-dev
* $ make clean && make -j8 && make test
* $ mkdir build && cd build && cmake .. && make -j8 && ./bin/krkr2/krkr2 && cd ..

## For Fedora 41, x86_64, in VirtualBox
* $ sudo yum install lftp gcc g++ make cmake gedit pkg-config
* $ sudo yum install glew-devel freetype-devel libjpeg-devel glfw-devel boost-devel fmt-devel opencv-devel libwebp-devel lz4-devel spdlog-devel openal-devel SDL2-devel gtk2-devel minizip-devel libarchive-devel libvorbis-devel opusfile-devel
* $ make clean && make -j8 && make test
* $ mkdir build && cd build && cmake .. && make -j8 && ./bin/krkr2/krkr2 && cd ..

## For Arch Linux 2025.04.01, x86_64, in VirtualBox
* For VirtualBox, change checkbox and combobox to enable Hyper-V, PAE/NX, Nested VT-x/AMD-V
* $ sudo pacman -Sy
* $ sudo pacman -S lftp gcc make cmake pkg-config  
* $ sudo pacman -S glew glfw boost fmt opencv spdlog openal gtk2 minizip opusfile  
* $ make clean && make -j8 && make test
* $ mkdir build && cd build && cmake .. && make -j8 && ./bin/krkr2/krkr2 && cd ..

## For Debian 12.10.0, amd64, in VirtualBox
* \# sudo apt update
* \# sudo apt install lftp gedit pkg-config make gcc g++ cmake
* \# sudo apt install libglew-dev libfreetype-dev libglfw3-dev libsdl2-dev libvorbis-dev libwebp-dev  libboost-locale-dev libfmt-dev libopencv-dev liblz4-dev libspdlog-dev libopenal-dev libgtk2.0-dev libarchive-dev libopusfile-dev libminizip-dev libjpeg-dev
* \# cp -r ./_testdata /home/wmt/_testdata
* \# make clean && make -j8 && make test
* \# mkdir build && cd build && cmake .. && make -j8 && ./bin/krkr2/krkr2 && cd ..

## (TODO, pending, not tested) For msys2, see readme_msys2.txt  
* Check if install to c:/msys64, otherwise modify it in Makefile.msys2
* $ pacman -Sy
* $ pacman -S mingw-w64-x86_64-libpng
* $ pacman -S mingw-w64-x86_64-libjpeg
* $ pacman -S mingw-w64-x86_64-libwebp
* $ pacman -S mingw-w64-x86_64-zlib
* $ pacman -S mingw-w64-x86_64-glew
* $ pacman -S mingw-w64-x86_64-gdb
* $ pacman -S mingw-w64-x86_64-glfw
* $ pacman -S mingw-w64-x86_64-opencv
* $ pacman -S mingw-w64-x86_64-minizip
* (Not sure) $ pacman -S mingw-w64-x86_64-boost
* $ pacman -S mingw-w64-x86_64-fmt
* $ pacman -S mingw-w64-x86_64-spdlog
* $ mingw32-make.exe -f Makefile.msys2 clean
* $ mingw32-make.exe -f Makefile.msys2 -j8
* $ mingw32-make.exe -f Makefile.msys2 test
* $ ./kirikiroid2.exe

## For Raspberry Pi OS 2023-05-03 Raspios Bullseye (Debian 11), arm32 (armhf), in Raspberry Pi 4B
* $ sudo apt update
* $ sudo apt install lftp gedit pkg-config make gcc g++ cmake
* $ sudo apt install libglew-dev libfreetype-dev libglfw3-dev libsdl2-dev libvorbis-dev libwebp-dev  libboost-locale-dev libfmt-dev libopencv-dev liblz4-dev libspdlog-dev libopenal-dev libgtk2.0-dev libarchive-dev libopusfile-dev libminizip-dev libjpeg-dev
* $ make clean && make -j4 && make test
* $ mkdir build && cd build && cmake .. && make -j4 && ./bin/krkr2/krkr2 && cd ..

## For Android NDK r25, armeabi-v7a, in Android 32bit
* Double click console.bat
* set PATH=D:\home\soft\android_studio_sdk\ndk\25.2.9519653;%PATH%
* set NDK_MODULE_PATH=%CD%\cocos;%CD%\external;%CD%\extensions;%CD%
* ndk-build -j8
* copy libs\armeabi-v7a\libSDL2.so project\androidstudio\app\libs\armeabi-v7a\libSDL2.so
* copy libs\armeabi-v7a\libcpp_empty_test.so project\androidstudio\app\libs\armeabi-v7a\libcpp_empty_test.so
* Open project\androidstudio with Android Studio


