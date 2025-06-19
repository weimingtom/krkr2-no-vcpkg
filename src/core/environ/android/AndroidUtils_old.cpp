#if !defined(ANDROID)
//skip
#else

#include "cocos2d.h"
#include <string>
std::string TVPGetDeviceID();
#if !MY_USE_MINLIB
#include "minizip/unzip.h"
#endif
#include "zlib.h"
#include <map>
#include <string>
#include <vector>
#include "tjs.h"
//#include "MsgIntf.h"
//#include "md5.h"
//#include "DebugIntf.h"

//???
//#ifndef _MSC_VER
//#include "platform/android/jni/JniHelper.h"
//#endif


#include <set>
#include <sstream>
#include "SysInitIntf.h"
//#include "platform/CCFileUtils.h"
#include "ConfigManager/LocaleConfigManager.h"
//#include "Platform.h"
//#include "platform/CCCommon.h"

//???
//#ifndef _MSC_VER
//#include <EGL/egl.h>
//#endif


//#include <queue>
//#include "base/CCDirector.h"
//#include "base/CCScheduler.h"
#include <unistd.h>
//#include <fcntl.h>
#include <android/log.h>
//#include "TickCount.h"
//#include "StorageImpl.h"
//#include "ConfigManager/IndividualConfigManager.h"
#include "EventIntf.h"
#include "RenderManager.h"
#include <sys/stat.h>
#include "Platform.h"
#include <locale>         // std::wstring_convert
#include <string>
#include <wchar.h>

# define LOG_TAG "AndroidUtils"
# define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__))

int TVPShowSimpleMessageBox(const ttstr & text, const ttstr & caption, const std::vector<ttstr> &vecButtons)
{
	LOGE("%s, %s", text.AsStdString().c_str(), caption.AsStdString().c_str());
	return 0;
}

std::string TVPGetPackageVersionString() {
	return "ver 1.0.0";
}
static std::wstring strInputBoxTitle;
static std::wstring strInputBoxPrompt;
static std::wstring strInputBoxText;

int TVPShowSimpleInputBox(ttstr &text, const ttstr &caption, const ttstr &prompt, const std::vector<ttstr> &vecButtons) {
	LOGE("TVPShowSimpleInputBox: %s, %s", text.AsStdString().c_str(), caption.AsStdString().c_str());
	throw;
	return 0;
}


bool TVPCheckExistentLocalFolder(const ttstr &name);
bool TVPCreateFolders(const ttstr &folder);
static bool _TVPCreateFolders(const ttstr &folder)
{
	// create directories along with "folder"
	if (folder.IsEmpty()) return true;

	if (TVPCheckExistentLocalFolder(folder))
		return true; // already created

	const tjs_char *p = folder.c_str();
	tjs_int i = folder.GetLen() - 1;

	if (p[i] == TJS_W(':')) return true;

	while (i >= 0 && (p[i] == TJS_W('/') || p[i] == TJS_W('\\'))) i--;

	if (i >= 0 && p[i] == TJS_W(':')) return true;

	for (; i >= 0; i--)
	{
		if (p[i] == TJS_W(':') || p[i] == TJS_W('/') ||
			p[i] == TJS_W('\\'))
			break;
	}

	ttstr parent(p, i + 1);
	if (!TVPCreateFolders(parent)) return false;

	return !mkdir(folder.AsStdString().c_str(), S_IRWXU|S_IRGRP|S_IROTH);

}
bool TVPCreateFolders(const ttstr &folder)
{
	if (folder.IsEmpty()) return true;

	const tjs_char *p = folder.c_str();
	tjs_int i = folder.GetLen() - 1;

	if (p[i] == TJS_W(':')) return true;

	if (p[i] == TJS_W('/') || p[i] == TJS_W('\\')) i--;

	return _TVPCreateFolders(ttstr(p, i + 1));
}

//see environ/win32/Platform.cpp
tjs_uint32 TVPGetRoughTickCount32()
{
	tjs_uint32 uptime = 0;
	struct timespec on;
	if (clock_gettime(CLOCK_MONOTONIC, &on) == 0)
		uptime = on.tv_sec * 1000 + on.tv_nsec / 1000000;
	return uptime;
}


bool TVP_stat(const tjs_char *name, tTVP_stat &s) {
	tTJSNarrowStringHolder holder(name);
	return TVP_stat(holder, s);
}

//#undef st_atime
//#undef st_ctime
//#undef st_mtime
//int stat64(const char* __path, struct stat64* __buf) __INTRODUCED_IN(21); // force link it !
bool TVP_stat(const char *name, tTVP_stat &s) {
	struct stat t;
	// static_assert(sizeof(t.st_size) == 4, "");
	static_assert(sizeof(t.st_size) == 8, "");
	bool ret = !stat(name, &t);
	s.st_mode = t.st_mode;
	s.st_size = t.st_size;
#if !MY_USE_MINLIB	
	s.st_atime = t.st_atime;
	s.st_mtime = t.st_mtime;
	s.st_ctime = t.st_ctime;
#endif	
	return ret;
}

bool TVPWriteDataToFile(const ttstr &filepath, const void *data, unsigned int size) {
	LOGE("====================>TVPWriteDataToFile: %s", filepath.AsStdString().c_str());
	FILE* handle = fopen(filepath.AsStdString().c_str(), "wb");
	if (handle) {
		bool ret = fwrite(data, 1, size, handle) == size;
		fclose(handle);
		return ret;
	}
	return false;
}

void TVPExitApplication(int code) {
	TVPDeliverCompactEvent(TVP_COMPACT_LEVEL_MAX);
	if (!TVPIsSoftwareRenderManager())
		iTVPTexture2D::RecycleProcess();
	exit(code);
}

tjs_int TVPGetSystemFreeMemory()
{
	throw;
	return 0;
}

int TVPShowSimpleMessageBox(const char *pszText, const char *pszTitle, unsigned int nButton, const char **btnText) {
	LOGE("TVPShowSimpleMessageBox: %s, %s", pszText, pszTitle);
	return 0;
}

bool TVPCheckStartupArg() {
	return false;
}

std::string TVPGetCurrentLanguage() {
	//throw;
	return "zh_cn";
}

void TVPProcessInputEvents() {}

void TVPControlAdDialog(int adType, int arg1, int arg2) {
	CCLOG("===================%d, %d, %d", adType, arg1, arg2);
}

std::vector<std::string> TVPGetDriverPath() {
	//throw;
	std::vector<std::string> ret;
	ret.push_back("/mnt/sdcard");
	return ret;
}

bool TVPCheckStartupPath(const std::string &path) {
	LOGE("=========================>TVPCheckStartupPath()");
	return true;
}

tjs_int TVPGetSelfUsedMemory()
{
	throw;
	return 0;
}

void TVPForceSwapBuffer() {
	LOGE("=========================>TVPForceSwapBuffer() not imp");
}

bool TVPDeleteFile(const std::string &filename) {
	throw;
	return false;
}

bool TVPRenameFile(const std::string &from, const std::string &to) {
	throw;
	return false;
}

void TVPSendToOtherApp(const std::string &filename) {
	throw;
}

void TVPFetchSDCardPermission() {
	throw;
}

std::string TVPGetDefaultFileDir() {
	char buf[255];
	getcwd(buf, sizeof(buf) / sizeof(buf[0]));
	char *p = buf;
	while (*p) {
		if (*p == '\\') *p = '/';
		++p;
	}
	return std::string(buf);
}
std::vector<std::string> TVPGetAppStoragePath() {
	std::vector<std::string> ret;
	ret.push_back(TVPGetDefaultFileDir());
	return ret;
}

void TVPOutputDebugString(const char *str) {
	LOGE("%s", str);
}



//---------------------------------------------
//NOTE:added
static int GetExternalStoragePath(std::vector<std::string> &ret) {
	int count = 0;
	ret.push_back(std::string("/mnt/sdcard"));
	++count;
	return count;
}
static std::string GetInternalStoragePath() {
	return std::string("/mnt/sdcard/");
}
static std::string GetApkStoragePath() {
	return std::string("/mnt/sdcard/");
}

std::vector<ttstr> Android_GetExternalStoragePath() {
	static std::vector<ttstr> ret;
	if (ret.empty()) {
		std::vector<std::string> pathlist;
		GetExternalStoragePath(pathlist);
		for (const std::string &path : pathlist) {
			std::string strPath = "file://.";
			strPath += path;
			ret.push_back(strPath);
		}
	}
	return ret;
}

ttstr Android_GetInternalStoragePath() {
	static ttstr strPath;
	if (strPath.IsEmpty()) {
		strPath = "file://.";
		strPath += GetInternalStoragePath();
	}
	return strPath;
}

ttstr Android_GetApkStoragePath() {
	static ttstr strPath;
	if (strPath.IsEmpty()) {
		strPath = "file://.";
		strPath += GetApkStoragePath();
	}
	return strPath;
}

void TVPHideIME() {
	LOGE("%s", "TVPHideIME");
}

void TVPShowIME(int x, int y, int w, int h) {
	LOGE("%s", "TVPShowIME");
}












#endif
