SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "AndroidAuto SDK" 
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://Readme.md;md5=0509180ef63e32381537b0d7aa9e5b7c"
SRC_URI = "git://github.com/vietkynl99/aasdk.git;protocol=https;branch=develop"
SRCREV = "develop"

DEPENDS += " protobuf protobuf-native boost libusb"

inherit cmake

# this is a revision number that should be updated every time you alter this recipe
PR = "r0" 

# TODO fix this path
S="${WORKDIR}/git"

do_compile[progress] = "percent"