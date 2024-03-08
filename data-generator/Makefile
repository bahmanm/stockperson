data-generator.root.dir := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))

####################################################################################################

data-generator.gradle.gradle ?= ./gradlew
data-generator.gradle.options ?= --console plain
data-generator.gradle.command = $(data-generator.gradle.gradle) $(data-generator.gradle.options)

####################################################################################################

data-generator.gradle(%) : bmakelib.default-if-blank( data-generator.gradle.user-options, )
data-generator.gradle(%) :
	cd $(data-generator.root.dir) \
	&& $(data-generator.gradle.command) $(*) \
	$(if $(data-generator.gradle.user-options),--args='$(data-generator.gradle.user-options)',)

####################################################################################################

.PHONY : data-generator.spotlessApply

data-generator.spotless-apply : data-generator.gradle( spotlessApply )
data-generator.spotless-apply : data-generator.gradle( spotlessGroovyGradleApply )
data-generator.spotless-apply : data-generator.gradle( spotlessMiscApply )

####################################################################################################

.PHONY : data-data-generator.spotlessCheck

data-generator.spotless-check : data-generator.gradle( spotlessCheck )
data-generator.spotless-check : data-generator.gradle( spotlessGroovyGradleCheck )
data-generator.spotless-check : data-generator.gradle( spotlessMiscCheck )

####################################################################################################

.PHONY : data-generator.build

data-generator.build : data-generator.gradle( classes testClasses )

####################################################################################################

.PHONY : data-generator.test

data-generator.test : data-generator.spotless-check
data-generator.test : data-generator.gradle( check )

####################################################################################################

.PHONY : data-generator.clean

data-generator.clean :
	-@rm -rf $(data-generator.root.dir)build

####################################################################################################

.PHONY : data-generator.run

data-generator.run : export SP_MAIN_CLASS = stockperson.datagenerator.chapter_1_0.Main
data-generator.run : data-generator.gradle.user-options ?=
data-generator.run : data-generator.gradle( run )

####################################################################################################

.PHONY : data-generator.package

data-generator.package : data-generator.test
data-generator.package : data-generator.gradle( assemble )
