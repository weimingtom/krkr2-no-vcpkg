Android NDK: D:\work_krkr2_android\krkr2-no-vcpkg\cocos/3d/Android.mk: Cannot find module with tag 'audio/android' in import path


\external\android-specific

APP_PLATFORM := 23


        [[nodiscard]] std::wstring toWString() const {
#if !defined(ANDROID)		
            return boost::locale::conv::utf_to_utf<wchar_t>(
                AsNarrowStdString());
#else
            std::string in_ = AsNarrowStdString();
		    tjs_int len = TVPUtf8ToWideCharString(in_.c_str(), 0, nullptr);
		    if(len < 0)
		        return L"";
		    tjs_char *buf = new tjs_char[len];
			std::wstring out;
		    if(buf) {
		        try {
		            len = TVPUtf8ToWideCharString(in_.c_str(), len, buf);
		            if(len > 0)
		                out.assign((wchar_t *)buf, len);
		            delete[] buf;
		        } catch(...) {
		            delete[] buf;
		            throw;
		        }
		    }
		    return out;
#endif
        }
		
		
-----------------		
		
    tTJSFuncTrace::tTJSFuncTrace(const tjs_char *p) :
#if !defined(ANDROID)	
        funcname(boost::locale::conv::utf_to_utf<char>(p)) {
        spdlog::debug("enter: {}", funcname);
#else
        funcname((const char *)p) {
		fprintf(stderr, "!!!not implement!!! [enter] %s", funcname.c_str());
#endif		
    }

#if !defined(ANDROID)	
    tTJSFuncTrace::~tTJSFuncTrace() { spdlog::debug("exit: {}", funcname); }
#else
	tTJSFuncTrace::~tTJSFuncTrace() { fprintf(stderr, "exit: %s", funcname.c_str()); }
#endif	


-------------------

#if !defined(ANDROID)
FIXME:??? += ????---->            buf = TJS_W("\t// ");
FIXME:??? += ????---->            buf = comment;
#else
			wcscat((wchar_t *)buf, L"\t// ");
			wcscat((wchar_t *)buf, (const wchar_t *)comment);
#endif

-----------------

        template <typename... T>
        size_t printf(const char *format, const T &...args) {
#if !defined(ANDROID)		
            std::u16string utf16_string =
                boost::locale::conv::utf_to_utf<char16_t>(
                    fmt::sprintf(format, args...));
            size_t len = utf16_string.length();
            AllocBuffer(len);
            TJS_strcpy(const_cast<tjs_char *>(c_str()), utf16_string.c_str());
            FixLen();
            return len;
#else
            char str[256] = {0};
            snprintf(str, 255, format, args...);


            std::string in_ = AsNarrowStdString();
		    tjs_int len = TVPUtf8ToWideCharString(str, 0, nullptr);
		    tjs_char *buf = new tjs_char[0];
			if(len < 0) {
??????????? not good-------->		    
			} else {
				tjs_char *buf = new tjs_char[len];
			    if(buf) {
			        try {
			            len = TVPUtf8ToWideCharString(str, len, buf);
			        } catch(...) {
			            throw;
			        }
			    }
			}
            AllocBuffer(len);
            TJS_strcpy(const_cast<tjs_char *>(c_str()), buf);
            FixLen();
            if (buf) {
				delete[] buf;
			} 
			return len;
#endif
        }
		
---------------

krkr2-no-vcpkg\src\core\sound\win32\WaveMixer.cpp

--------------------
krkr2-no-vcpkg\src\core\base\win32\StorageImpl.cpp

#if !MY_USE_MINLIB
#else
	fprintf(stderr, "%s\n", "==================>TVPListDir");
#endif	

-------------------


-O3版会crash，-O0版则不会，然后我分析了gdb调用栈，
发现tjsString.h有个判断Ptr为空的保护代码（!Ptr）会被gcc -O3优化掉，
我把预编译条件改成if 1就可以解决这个crash问题。

src/core/tjs2/tjsString.h
https://github.com/weimingtom/kirikiroid2-miyoo-a30/blob/master/src/core/tjs2/tjsString.h

	TJS_CONST_METHOD_DEF(tjs_int, GetLen, ())
	{
//#ifdef __CODEGUARD__
//FIXME:#if defined(LINUX), if without this code, then gcc -O3 -g0 and run will crash
#if 1
		if(!Ptr) return 0; // tTJSVariantString::GetLength can return zero if 'this' is NULL
#endif
		return Ptr->GetLength();
	}
	
	
	
#if !MY_USE_MINLIB		
        [[nodiscard]] tjs_int GetLen() const { return Ptr->GetLength(); }
#else
		[[nodiscard]] tjs_int GetLen() const { 
		//#ifdef __CODEGUARD__
		//FIXME:#if defined(LINUX), if without this code, then gcc -O3 -g0 and run will crash
		#if 1
				if(!Ptr) return 0; // tTJSVariantString::GetLength can return zero if 'this' is NULL
		#endif
				return Ptr->GetLength();
		}
#endif	
	
----------------------


core/environ/android/AndroidUtils.cpp


use old, TODO: how to use new

-----------------------

