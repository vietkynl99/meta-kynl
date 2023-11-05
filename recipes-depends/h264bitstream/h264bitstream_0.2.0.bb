DESCRIPTION = "A complete set of functions to read and write H.264 video bitstreams, in particular to examine or modify headers."
SECTION = "libs"
LICENSE = "GPL-2.1"
HOMEPAGE = "https://github.com/aizvorski/h264bitstream"

PR = "r0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a6f89e2100d9b6cdffcea4f398e37343"
SRC_URI = "git://github.com/aizvorski/h264bitstream.git;protocol=https;branch=master"
SRCREV = "34f3c58afa3c47b6cf0a49308a68cbf89c5e0bff"

S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "${libdir}/* /usr/share"