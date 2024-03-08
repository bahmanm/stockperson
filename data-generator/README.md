# StockPerson data-generator

The test data generator to be used by implementations of StockPerson.

### Supported chapters

* [📗 Chapter 1.0](https://github.com/bahmanm/stockperson?tab=readme-ov-file#-chapter-10)

# Getting Started

#### Get the latest version

Download the latest release from the [release page](https://github.com/bahmanm/stockperson/releases) on the repository and extract it.

For example:

```
＄ URL='https://github.com/bahmanm/stockperson/releases/download/v0.1.0/data-generator.tar'
＄ wget -O - ${URL} | tar -xf
```

## Running the Data Generator

data-generator runs on the JVM. This means you either need Java or Docker installed.

#### Using Java

_To check the version of Java on your machine, run `java -version`._


Assuming you've got JDK 11, JDK 17 or JDK 21 installed:

```
＄ cd data-generator
＄ bin/data-generator --help
Usage: Main [OPTION1] [OPTION2] ...
StockPerson Data Generator - Chapter 1.0
  -h, --help                Show this help.
      --invoice-count=<N>   How many invoices to generate?
      --invoice-file=<file> Path (absolute or relative) to the invoices file.
```

#### Using Docker

_Docker is a tool that lets you run applications in packaged environments called containers._

Assuming you've got Docker running, use the image provided by [bdockerimg](https://github.com/bahmanm/bdockerimg) to simplify things:

```
＄ cd data-generator
＄ docker run --rm --volume .:/project bdockerimg/sdkman \
    'sdk install java 17.0.10-tem && bin/data-generator --help'
Downloading: java 17.0.10-tem
...
Done installing!
...
Usage: Main [OPTION1] [OPTION2] ...
StockPerson Data Generator - Chapter 1.0
  -h, --help                Show this help.
      --invoice-count=<N>   How many invoices to generate?
      --invoice-file=<file> Path (absolute or relative) to the invoices file.
```
