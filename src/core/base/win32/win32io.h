#pragma once
#ifdef WIN32
#include <io.h>
#if !defined(__MINGW32__)
// posix io api
inline unsigned int lseek64(int fileHandle, __int64 offset, int origin) {
    return _lseeki64(fileHandle, offset, origin);
}
#endif
// extern void *valloc(int n);
// extern void vfree(void *p);
// }
#endif
#ifdef CC_TARGET_OS_IPHONE
#define lseek64 lseek
#endif