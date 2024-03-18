# StockPerson [![CircleCI](https://dl.circleci.com/status-badge/img/circleci/UMKeFZ8ns9T9vi5aquTfVT/SMpnX4zqrRqMcDN3Lsw3Wv/tree/main.svg?style=shield&circle-token=9e1ebe32944ff6e34c4f422aece05cd7c16a5654)](https://dl.circleci.com/status-badge/redirect/circleci/UMKeFZ8ns9T9vi5aquTfVT/SMpnX4zqrRqMcDN3Lsw3Wv/tree/main)

A collection of exercises that you can use to learn a new programming language, or even revisit a
language you're already familiar with.

<img alt="StockPerson logo" src="https://imgur.com/Df344bg.png" style="height: 300px; width: 300px; vertical-align: top" />

* The exercises are grouped in chapters.
* There is no inter-dependency between chapters.
* Each chapter is noticeably more involved and complex than its predecessor.
* The exercises try to create a real-world experience in the following areas:
  * Data modeling
  * Data structures
  * Input/Output
  * Refactoring/Extending an existing codebase

## How to approach

The idea that **I** follow when using StockPerson is to assume I'm a contractor who

* is contracted for a single chapter
* is paid only for the chapter's user-facing functionality
* has been told that they're most probably not going to get the next chapter

There are usually 2 approaches to working on a chapter:

* Focusing on the end-user functionality and do only as much as technically required to tackle **just** the current chapter.
* Focusing on trying to implement a robust design with the idea of reusing the code in the future chapters.

Either approach works just fine for the purpose of StockPerson and it's mostly a matter of personal preference.

## Chapters

### 📗 Chapter 1.0

1. Read a CSV file that contains sales invoice lines.
2. Pretty-print the invoices in a document style.

> [!NOTE]
> If you don't what exactly "pretty-print" entails, you take a look at an example [here.](./assets/prettyprint_example.txt)

### 📗 Chapter 2.0

1. Read a CSV file that contains sales invoice lines.
2. Find the total sales.
3. Find the most expensive invoice and pretty print it in a document style.
4. Find the most expensive product and print its code.
5. Calculate the average price of each product, and print the the list of prices in descending order.
6. Find the total sales per customer and print a list in descending order in the form `customer, total`.
7. Find the customer with the largest total sales.
8. Find the 3 customers with the least total sales and print a list in descending format in the form `customer, total`.
9. Find the date with the largest total sales amount.

### 📗 Chapter 3.0

> [!IMPORTANT]
> It is important to process the invoices in the order they appear in the CSV.

1. Read a CSV file that contains product inventory.
2. Read a CSV file that contains sales invoice lines.
3. Check if the product referenced on each line has enough inventory.
	1. If no, do not import the invoice to which the line belongs.
	2. If yes, import the invoice line and update the inventory of the product accordingly.
4. Print a list of invoices listing the problematic line(s) for each invoice.

### 📗 Chapter 4.0

> [!IMPORTANT]
> It is important to process any given invoice only once all the other invoices with earlier timestamps have been processed.

1. Read a CSV file that contains product inventory.
2. Read a CSV file that contains sales invoice lines, where each invoice has a timestamp denoting the transaction date and time.
3. Check if the product referenced on each line has enough inventory.
	1. If no, do not import the invoice to which the line belongs.
	2. If yes, import the invoice line and update the inventory of the product accordingly.
4. Print a list of invoices listing the problematic line(s) for each invoice.

### 📗 Chapter 5.0

> [!IMPORTANT]
> It is important to process any given invoice only once all the other invoices (sales and purchase) with earlier timestamps have been processed.

1. Read a CSV file that contains product inventory.
2. Read two CSV files, one containing sales invoice lines and the other containing purchase invoice lines.
	lines. Each invoice has a timestamp which denotes the transaction date and time.
3. Check if the product referenced on each sales invoice line has enough inventory.
	1. If no, do not import the sales invoice to which the line belongs.
	2. If yes, import the invoice line and update the inventory of the product accordingly.
4. Print a list of sales invoices listing the problematic line(s) for each invoice.

## Sample Data

[Chapter 1](./sample-data/chapter-1.0/)

_More sample data to be pre-generated._

## Trivia

The idea for StockPerson came to me around 2008 as I was learning Smalltalk. It has continued to be a valuable learning tool for exploring new languages ever since, eg Erlang, D, etc.
