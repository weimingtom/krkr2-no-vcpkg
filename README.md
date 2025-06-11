# krkr2-no-vcpkg
[WIP and not recommended] build krkr2 kirikiroid2 vcpkg version without vcpkg, with apt install instead

## For Xubuntu 20.04 and Xubuntu 25.04
* $ sudo apt update
* $ sudo apt install lftp gedit pkg-config make gcc g++ cmake
* $ sudo apt install libglew-dev libfreetype-dev libglfw3-dev libsdl2-dev libvorbis-dev libwebp-dev  libboost-locale-dev libfmt-dev libopencv-dev libturbojpeg0-dev liblz4-dev libspdlog-dev libopenal-dev libgtk2.0-dev libarchive-dev libopusfile-dev libminizip-dev
* $ make clean && make -j8 && make test
* $ mkdir build && cd build && cmake .. && make -j8 && ./bin/krkr2/krkr2
