SUMMARY = "Easy API to create and parse X.509 and CMS related objects"
HOMEPAGE = "http://www.gnupg.org/related_software/libksba/"
LICENSE = "GPLv3+ & (GPLv2+ | LGPLv3+)"
LICENSE_${PN} = "GPLv2+ | LGPLv3+"
LICENSE_${PN}-doc = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=fd541d83f75d038c4e0617b672ed8bda \
                    file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://COPYING.GPLv3;md5=2f31b266d3440dd7ee50f92cf67d8e6c \
                    file://COPYING.LGPLv3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
                   "

DEPENDS = "libgpg-error"

BINCONFIG = "${bindir}/ksba-config"

inherit autotools binconfig-disabled pkgconfig texinfo

UPSTREAM_CHECK_URI = "https://gnupg.org/download/index.html"
SRC_URI = "${GNUPG_MIRROR}/${BPN}/${BPN}-${PV}.tar.bz2 \
           file://ksba-add-pkgconfig-support.patch"

SRC_URI[md5sum] = "8302a3e263a7c630aa7dea7d341f07a2"
SRC_URI[sha256sum] = "41444fd7a6ff73a79ad9728f985e71c9ba8cd3e5e53358e70d5f066d35c1a340"

do_configure_prepend () {
	# Else these could be used in preference to those in aclocal-copy
	rm -f ${S}/m4/gpg-error.m4
}

BBCLASSEXTEND = "native"
