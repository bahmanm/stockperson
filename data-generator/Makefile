data-generator.root.dir := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))

####################################################################################################

data-generator.gradle.gradle ?= ./gradlew
data-generator.gradle.options ?= --console plain
data-generator.gradle.command = $(data-generator.gradle.gradle) $(data-generator.gradle.options)

####################################################################################################

data-generator.gradle(%) :
	cd $(data-generator.root.dir) \
	&& $(data-generator.gradle.command) $(*)

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
