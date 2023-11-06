SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "OpenAuto" 
SECTION = "utils"
LICENSE = "GPL-3.0" 
LIC_FILES_CHKSUM = "file://Readme.md;md5=ad4ce51cdaff9cf863fd0b170e65ff71"
SRC_URI = "git://github.com/vietkynl99/openauto.git;protocol=https;branch=develop"
SRCREV = "develop"

DEPENDS += "aasdk qt-gstreamer h264bitstream pulseaudio gpsd taglib util-linux librtaudio qtbase qtconnectivity qtmultimedia protobuf protobuf-native"

inherit cmake_qt5

# Build for Raspberrypi
EXTRA_OECMAKE += "-DRPI_BUILD=TRUE"

# Use Gstreamer video output
# EXTRA_OECMAKE += "-DGST_BUILD=TRUE"
 
# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# this indicates the folder to run do_compile from.
S="${WORKDIR}/git"

INSANE_SKIP_${PN} = "dev-deps"
do_compile[progress] = "percent"