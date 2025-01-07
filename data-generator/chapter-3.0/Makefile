data-generator.chapter-3.0.dir.root := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))
data-generaotr.chapter-3.0.dir.build := $(data-generator.chapter-3.0.dir.root)build/

####################################################################################################

data-generator.chapter-3.0.gradle.gradle ?= ./gradlew
data-generator.chapter-3.0.gradle.options ?= --console plain
data-generator.chapter-3.0.gradle.command = $(data-generator.chapter-3.0.gradle.gradle) $(data-generator.chapter-3.0.gradle.options)

####################################################################################################

data-generator.chapter-3.0.gradle(%) : bmakelib.default-if-blank( data-generator.chapter-3.0.gradle.user-options, )
data-generator.chapter-3.0.gradle(%) :
	cd $(data-generator.chapter-3.0.dir.root) \
	&& $(data-generator.chapter-3.0.gradle.command) $(*) \
	$(if $(data-generator.chapter-3.0.gradle.user-options),--args='$(data-generator.chapter-3.0.gradle.user-options)',)

####################################################################################################

.PHONY : data-generator.chapter-3.0.spotlessApply

data-generator.chapter-3.0.spotless-apply : data-generator.chapter-3.0.gradle( spotlessApply )
data-generator.chapter-3.0.spotless-apply : data-generator.chapter-3.0.gradle( spotlessGroovyGradleApply )
data-generator.chapter-3.0.spotless-apply : data-generator.chapter-3.0.gradle( spotlessMiscApply )

####################################################################################################

.PHONY : data-generator.chapter-3.0.spotlessCheck

data-generator.chapter-3.0.spotless-check : data-generator.chapter-3.0.gradle( spotlessCheck )
data-generator.chapter-3.0.spotless-check : data-generator.chapter-3.0.gradle( spotlessGroovyGradleCheck )
data-generator.chapter-3.0.spotless-check : data-generator.chapter-3.0.gradle( spotlessMiscCheck )

####################################################################################################

.PHONY : data-generator.chapter-3.0.build

data-generator.build : data-generator.chapter-3.0.gradle( classes testClasses )

####################################################################################################

.PHONY : data-generator.chapter-3.0.test

data-generator.test : data-generator.chapter-3.0.spotless-check
data-generator.test : data-generator.chapter-3.0.gradle( check )

####################################################################################################

.PHONY : data-generator.chapter-3.0.clean

data-generator.chapter-3.0.clean :
	-@rm -rf $(data-generaotr.chapter-3.0.dir.build)

####################################################################################################

.PHONY : data-generator.chapter-3.0.run

data-generator.chapter-3.0.run : export SP_MAIN_CLASS = stockperson.datagenerator.chapter_1_0.Main
data-generator.chapter-3.0.run : data-generator.chapter-3.0.gradle.user-options ?=
data-generator.chapter-3.0.run : data-generator.chapter-3.0.gradle( run )

####################################################################################################

.PHONY : data-generator.chapter-3.0.package

data-generator.chapter-3.0.package : data-generator.chapter-3.0.test
data-generator.chapter-3.0.package : data-generator.chapter-3.0.gradle( assemble )
