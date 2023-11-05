SUMMARY = "A very basic Wayland image with a terminal. Based on core-image-weston and my custom features."

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs"

LICENSE = "MIT"

inherit core-image features_check

REQUIRED_DISTRO_FEATURES = "wayland"

CORE_IMAGE_BASE_INSTALL += "weston weston-init weston-examples gtk+3-demo clutter-1.0-examples"
CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"

# DEPENDS += " protobuf-c"
# CORE_IMAGE_BASE_INSTALL += "protobuf protobuf-native"
CORE_IMAGE_BASE_INSTALL += "openauto"

#    qtquick3d
#    qtdatavis3d
#    qtgraphicaleffects
#    qtremoteobjects

QT_PACKAGES += " \
    qt3d \
    qtbase \
    qtcharts \
    qtconnectivity \
    qtdeclarative \
    qtdeclarative-tools \
    qtgamepad \
    qtimageformats \
    qtlocation \
    qtmultimedia \
    qtnetworkauth \
    qtquickcontrols \
    qtquickcontrols2 \
    qtquicktimeline \
    qtscxml \
    qtsensors \
    qtserialbus \
    qtserialport \
    qtsvg \
    qttools \
    qttools-tools \
    qttranslations-qtbase \
    qttranslations-qtdeclarative \
    qttranslations-qtconnectivity \
    qttranslations-qtlocation \
    qttranslations-qtmultimedia \
    qttranslations-qtquickcontrols \
    qttranslations-qtserialport \
    qttranslations-qtwebsockets \
    qttranslations-qtxmlpatterns \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'webengine', 'qtwebengine qttranslations-qtwebengine qtwebview', '', d)} \
    qtwebsockets \
    qtwebchannel \
    qtwebglplugin \
    qtxmlpatterns \
    qtvirtualkeyboard \
    "

IMAGE_INSTALL += "${QT_PACKAGES}"

