SUMMARY = "liion rbf file installation into boot partition"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "1.0${PR}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = 			" \
				file://soc_system.rbf \
          			"

# avoid QA error by skipping QA test for ldflags
INSANE_SKIP_${PN} = "ldflags"

do_install () {
	install -d ${D}/images/${MACHINE}/
	install -m 0777 ${WORKDIR}/soc_system.rbf ${D}/images/${MACHINE}/
	cp ${WORKDIR}/soc_system.rbf ${DEPLOY_DIR}/images/${MACHINE}/
}

FILES_${PN} += "/images/${MACHINE}/"




