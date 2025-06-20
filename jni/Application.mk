#APP_STL := gnustl_static
#for NDK r25
APP_STL := c++_static

APP_PLATFORM := 23

APP_CFLAGS := -DMY_USE_MINLIB=1
APP_CPPFLAGS := -frtti -DCC_ENABLE_CHIPMUNK_INTEGRATION=1 -std=c++17 -fsigned-char -Wno-extern-c-compat    -fpermissive -Wno-inconsistent-missing-override -Wno-null-dereference -Wno-deprecated-declarations -DMY_USE_MINLIB=1
#-fpermissive for c++_static for cocos2d-x-3.6/extensions/assets-manager/AssetsManagerEx.cpp 
APP_LDFLAGS := -latomic


ifeq ($(NDK_DEBUG),1)
  APP_CPPFLAGS += -DCOCOS2D_DEBUG=1
  APP_OPTIM := debug
else
  APP_CPPFLAGS += -DNDEBUG
  APP_OPTIM := release
endif

#APP_ABI := armeabi
#for NDK25
APP_ABI := armeabi-v7a

#don't use APP_SHORT_COMMANDS, I can't make -j8 if use this, so remove it
######APP_SHORT_COMMANDS := true

