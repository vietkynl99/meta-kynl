# meta-kynl

Yocto layer is used to build a Linux image containing the Qt features and OpenAuto application (similar to Android Auto)

## Dependencies

  URI: https://github.com/vietkynl99/aasdk
  branch: develop

  URI: https://github.com/vietkynl99/openauto
  branch: develop

  URI: https://github.com/GStreamer/qt-gstreamer
  branch: master

  URI: https://github.com/aizvorski/h264bitstream
  branch: master
  version: 0.2.0

  URI: https://github.com/thestk/rtaudio
  branch: master
  version: 5.1.0

## How to build Raspberrypi 4 image
### 1. Setup yocto
```
mkdir yocto
cd yocto
export YOCTO_DIR=$(pwd)
git clone -b dunfell git://git.yoctoproject.org/poky.git
git clone -b dunfell git://git.openembedded.org/meta-openembedded
git clone -b dunfell git://git.yoctoproject.org/meta-raspberrypi.git
git clone -b master https://github.com/meta-qt5/meta-qt5.git
git clone -b main https://github.com/vietkynl99/meta-kynl.git

source poky/oe-init-build-env
bitbake-layers add-layer ../meta-openembedded/meta-oe
bitbake-layers add-layer ../meta-openembedded/meta-python
bitbake-layers add-layer ../meta-openembedded/meta-multimedia
bitbake-layers add-layer ../meta-openembedded/meta-networking
bitbake-layers add-layer ../meta-raspberrypi
bitbake-layers add-layer ../meta-qt5
bitbake-layers add-layer ../meta-kynl
```
### 2. Edit build config: add to file build/conf/local.conf
```
# target
MACHINE = "raspberrypi4-64"
EXTRA_IMAGE_FEATURES_append = " ssh-server-dropbear"
# add a recipe
CORE_IMAGE_EXTRA_INSTALL_append = " nano"

# optional configs
# video camera support
VIDEO_CAMERA = "1"
# using U_boot
RPI_USE_U_BOOT = "1"
ENABLE_UART = "1"
BOOT_DELAY = "1"
# debug console via serial
SERIAL_CONSOLES ?= "115200;ttyS0"
SERIAL_CONSOLES_CHECK = "slcp_line0:ttyS0"
```
### 3. Build image
```
bitbake core-image-kynl
```
### 4. Flash to SD card
```
cd ${YOCTO_DIR}/build/tmp/deploy/images/raspberrypi4-64
bzip2 -d -f core-image-kynl-raspberrypi4-64.wic.bz2
```
Copy the file core-image-kynl-raspberrypi4-64.wic and use balenaEtcher to flash it
