inherit core-image

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_INSTALL += " \
	u-boot-socfpga \
	my-custom-soc-board-rbf \
"

export IMAGE_BASENAME = "my-custom-soc-board-console-image-minimal"

IMAGE_FEATURES += "package-management"

#overload timestamp function in image.bbclass

rootfs_update_timestamp () {
        date -u +%4Y%2m%2d%2H%2M -d "+1 day">${IMAGE_ROOTFS}/etc/timestamp
}

EXPORT_FUNCTIONS rootfs_update_timestamp

