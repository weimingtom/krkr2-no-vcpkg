#cmake_minimum_required(VERSION 3.28)
cmake_minimum_required(VERSION 3.6)
project(krkr2core)

add_subdirectory(base)
add_subdirectory(environ)
add_subdirectory(movie)
add_subdirectory(msg)
add_subdirectory(sound)
add_subdirectory(visual)
add_subdirectory(tjs2)
add_subdirectory(utils)

# Create the static library
add_library(${PROJECT_NAME} STATIC
    ${BASE_SOURCE_FILES}
    ${UTILS_SOURCE_FILES}
    ${ENVIRON_SOURCE_FILES}
    ${KRKR2CORE_PATH}/extension/Extension.cpp
    ${MOVIE_SOURCE_FILES}
    ${MSG_SOURCE_FILES}
    ${SOUND_SOURCE_FILES}
    ${VISUAL_SOURCE_FILES}
)

# Common include directories
target_include_directories(${PROJECT_NAME} PUBLIC
    ${BASE_HEADERS_DIR}
    ${UTILS_HEADERS_DIR}
    ${ENVIRON_HEADERS_DIR}
    ${KRKR2CORE_PATH}/extension
    ${MOVIE_HEADERS_DIR}
    ${MSG_HEADERS_DIR}
    ${SOUND_HEADERS_DIR}
    ${VISUAL_HEADERS_DIR}
    ${KRKR2CORE_PATH}/
    ${KRKR2CORE_PATH}/../plugins
    ${KRKR2CORE_PATH}/../../external
    ${KRKR2CORE_PATH}/../../external/unzip
    ${KRKR2CORE_PATH}/../../cocos
    ${KRKR2CORE_PATH}/../..
    ${KRKR2CORE_PATH}/../../extensions
    ${KRKR2CORE_PATH}/../../cocos/editor-support
    /usr/include/gtk-2.0
    /usr/include/glib-2.0 
    /usr/lib/x86_64-linux-gnu/glib-2.0/include 
    /usr/include/cairo 
    /usr/include/pango-1.0
    /usr/include/harfbuzz
    /usr/lib/x86_64-linux-gnu/gtk-2.0/include
    /usr/include/gdk-pixbuf-2.0 
    /usr/include/atk-1.0
    /usr/include/GLFW
    /usr/include/opus
    /usr/include/webp
    /usr/include/opencv4
    /usr/include/freetype2
#FXIME:for Fedora    
    PUBLIC /usr/lib64/glib-2.0/include
    PUBLIC /usr/lib64/gtk-2.0/include    
)
#FIXME:added, ../../external, ../../cocos

target_compile_definitions(${PROJECT_NAME} PUBLIC
    -DTJS_TEXT_OUT_CRLF
    -D__STDC_CONSTANT_MACROS
    -DUSE_UNICODE_FSTRING
)

#############
#FIXME:TODO:export from ../../cocos/CMakeLists.txt
#FIXME:added
add_definitions(-DCC_ENABLE_BOX2D_INTEGRATION=0 -DCC_USE_PHYSICS=0)
add_definitions(-DCC_USE_3D_PHYSICS=0 -DCC_ENABLE_BULLET_INTEGRATION=0 -DCC_USE_NAVMESH=0)
add_definitions(-DCC_USE_WEBP=0 -DCC_USE_TIFF=0)

#FIXME:added
add_definitions(-DGLFW_DLL)
add_definitions(-DLINUX)
add_definitions(-DCOCOS2D_DEBUG=1)

#FIXME:added
add_definitions(-DMY_USE_FREESERIF=1)
add_definitions(-DMY_USE_UIBUTTON_SETTITLECOLOR=1)
add_definitions(-DMY_USE_UNRARSRC=0)
add_definitions(-DMY_USE_LIBBPG=0)
add_definitions(-DMY_USE_LIBJXR=0)
add_definitions(-DMY_USE_LIB7ZIP=0)
add_definitions(-DMY_USE_PARTICLE3D=0)
#############
add_definitions(-DMY_USE_FFMPEG=0)

target_link_libraries(${PROJECT_NAME} PUBLIC tjs2 minizip)

# 启用 OpenMP 支持
find_package(OpenMP REQUIRED)

target_link_libraries(${PROJECT_NAME} PRIVATE OpenMP::OpenMP_CXX)
target_compile_options(${PROJECT_NAME} PRIVATE ${OpenMP_CXX_FLAGS})

if(ANDROID)
    target_link_libraries(${PROJECT_NAME} PUBLIC
        log
        android
        EGL
        GLESv2
        GLESv1_CM
        OpenSLES
    )
endif()

# oboe
if(ANDROID)
    find_package (oboe CONFIG REQUIRED)
    target_link_libraries(${PROJECT_NAME} PUBLIC oboe::oboe)
endif()

#find_package(unofficial-breakpad CONFIG REQUIRED)

# JXR library
#find_package(JXR REQUIRED)
#target_compile_definitions(${PROJECT_NAME} PUBLIC -D__ANSI__)
#target_include_directories(${PROJECT_NAME} PUBLIC ${JXR_INCLUDE_DIRS})

find_package(JPEG REQUIRED)
#find_package(libjpeg-turbo CONFIG REQUIRED)
#find_package(oniguruma CONFIG REQUIRED)
#find_package(libbpg CONFIG REQUIRED)
#find_package(unrar CONFIG REQUIRED)
#find_package(7zip CONFIG REQUIRED)
#find_package(Opus CONFIG REQUIRED)
#find_package(Ogg CONFIG REQUIRED)
#find_package(Vorbis CONFIG REQUIRED)
#find_package(OpusFile CONFIG REQUIRED)
#find_package(lz4 CONFIG REQUIRED)

find_package(SDL2 CONFIG REQUIRED)

find_package(LibArchive REQUIRED)

#find_package(OpenAL CONFIG REQUIRED)

#set(OpenCV_ROOT "${VCPKG_INSTALLED_DIR}/${VCPKG_TARGET_TRIPLET}/share/opencv4")
#find_package(OpenCV REQUIRED)

#find_package(FFMPEG COMPONENTS
#    avutil
#    avfilter
#    avcodec
#    swscale
#    swresample REQUIRED
#)
#target_include_directories(${PROJECT_NAME} PUBLIC ${FFMPEG_INCLUDE_DIRS})

# cocos2dx
#find_package(cocos2dx CONFIG REQUIRED)

# Link libraries
target_link_libraries(${PROJECT_NAME} PUBLIC
#    ${FFMPEG_LIBRARIES}

    # audio
#    Ogg::ogg
#    Opus::opus
#    Vorbis::vorbis
#    Vorbis::vorbisfile
#    Vorbis::vorbisenc
#    OpusFile::opusfile
#    OpenAL::OpenAL

    # image
    JPEG::JPEG
#    $<IF:$<TARGET_EXISTS:libjpeg-turbo::turbojpeg>,libjpeg-turbo::turbojpeg,libjpeg-turbo::turbojpeg-static>
#    opencv_imgproc
#    opencv_core

    # archive
#    7zip::7zip
#    unrar::unrar
#    lz4::lz4
#    LibArchive::LibArchive
#    libbpg::libbpg
#    ${JXR_LIBRARIES}

    # others
#    oniguruma::onig
#    unofficial::breakpad::libbreakpad_client

    # framework
#    $<TARGET_NAME_IF_EXISTS:SDL2::SDL2main>
#    $<IF:$<TARGET_EXISTS:SDL2::SDL2>,SDL2::SDL2,SDL2::SDL2-static>

    # cocos2d
#    cocos2dx::cocos2d
#    $<$<BOOL:${ANDROID}>:$<LINK_LIBRARY:WHOLE_ARCHIVE,cocos2dx::cpp_android_spec>>
)

#FIXME:added, for cocos2d-x
add_definitions(-DLINUX)

