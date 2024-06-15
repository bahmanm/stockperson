data-generator.dir.root := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))

####################################################################################################

data-generator.chapters := 1.0
data-generator.chapters.makefiles := $(data-generator.chapters:%=$(data-generator.dir.root)chapter-%/Makefile)

.PHONY : $(data-generator.chapters.makefiles)
include  $(data-generator.chapters.makefiles)

####################################################################################################

.PHONY : data-generator.clean

data-generator.clean : $(data-generator.chapters:%=data-generator.chapter-%.clean)

####################################################################################################

.PHONY : data-generator.build

data-generator.build : $(data-generator.chapters:%=data-generator.chapter-%.build)

####################################################################################################

.PHONY : data-generator.test

data-generator.test : $(data-generator.chapters:%=data-generator.chapter-%.test)

####################################################################################################

.PHONY : data-generator.run

data-generator.run : $(data-generator.chapters:%=data-generator.chapter-%.run)

####################################################################################################

.PHONY : data-generator.package

data-generator.package : $(data-generator.chapters:%=data-generator.chapter-%.package)

####################################################################################################
