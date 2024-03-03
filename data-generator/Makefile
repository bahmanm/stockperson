data-generator.root.dir := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))

####################################################################################################

.PHONY : data-generator.build

data-generator.build :
	cd $(data-generator.root.dir) \
	&& ./gradlew classes testClasses

####################################################################################################

.PHONY : data-generator.test

data-generator.test :
	cd $(data-generator.root.dir)\
	&& ./gradlew check
