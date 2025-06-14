# krkr2-no-vcpkg
[WIP and not recommended] build krkr2 kirikiroid2 vcpkg version without vcpkg, with apt install instead

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

## For Raspberry Pi OS 2023-05-03 Raspios Bullseye (Debian 11), arm32 (armhf), in Raspberry Pi 4B
* $ sudo apt update
* $ sudo apt install lftp gedit pkg-config make gcc g++ cmake
* $ sudo apt install libglew-dev libfreetype-dev libglfw3-dev libsdl2-dev libvorbis-dev libwebp-dev  libboost-locale-dev libfmt-dev libopencv-dev liblz4-dev libspdlog-dev libopenal-dev libgtk2.0-dev libarchive-dev libopusfile-dev libminizip-dev libjpeg-dev
* $ make clean && make -j4 && make test
* $ mkdir build && cd build && cmake .. && make -j4 && ./bin/krkr2/krkr2 && cd ..
