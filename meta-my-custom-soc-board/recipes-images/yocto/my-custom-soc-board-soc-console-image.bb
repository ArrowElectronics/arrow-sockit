inherit core-image

IMAGE_INSTALL += " \
	liion-hmi-app \
	liion-hmi-app-init \
	liion-rbf \
	altera-gsrd-pio-interrupt \
	liion-ab-bms-soc-usb-gadget \
	bash \
	ethtool \
	gcc \
	gdb \
	gdbserver \
	i2c-tools \
	iw \
	kernel-dev \
	kernel-image \
	kernel-modules \
	lighttpd \
	lighttpd-module-cgi \
	net-tools \
	nfs-utils-client \
	openssh \
	python \
	tar \
	usbutils \
	vim \
	vim-vimrc \
"

export IMAGE_BASENAME = "liion-ab-bms-soc-console-image"

IMAGE_FEATURES += "package-management"

#overload timestamp function in image.bbclass

rootfs_update_timestamp () {
        date -u +%4Y%2m%2d%2H%2M -d "+1 day">${IMAGE_ROOTFS}/etc/timestamp
}

EXPORT_FUNCTIONS rootfs_update_timestamp

