SHELL := /usr/bin/env -S bash -e -o pipefail
.DEFAULT_TARGET = test

####################################################################################################

root.dir := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))

####################################################################################################

.PHONY : bmakelib/bmakelib.mk
include  bmakelib/bmakelib.mk

####################################################################################################

subprojects := data-generator
subprojects.makefiles := $(subprojects:%=$(root.dir)%/Makefile)

.PHONY : $(subprojects.makefiles)
include  $(subprojects.makefiles)

####################################################################################################

.PHONY : build

build : $(subprojects:%=%.build)

####################################################################################################

.PHONY : test

test : $(subprojects:%=%.test)

####################################################################################################
