# stockperson

# Chapters

### 📗 Chapter 1.0

1. Read a CSV file into memory which contain sales invoice lines.
2. Pretty print the invoices.

### 📗 Chapter 2.0

1. Read a CSV file into memory which contain sales invoice lines.
2. Find the total sales.
3. Find the most expensive invoice and pretty print it.
4. Find the most expensive product and print its code.
5. Calculate the average price of each product, and print the the list of prices descendingly.
6. Find the total sales per customer and print a descending list in the form "customer, total".
7. Find the customer with the largest total sales.
8. Find the 3 customers with the least total sales and print a descending list in the form "customer, total".
9. Find the date with the largest total sales amount.

### 📗 Chapter 3.0
1. Read a CSV file into memory which contains product inventory.
2. Read a CSV file into memory which contain sales invoice lines.
3. Check if the product referenced on each line has enough inventory.
   1. If no, do not import the invoice to which the line belongs.
   2. If yes, import the invoice line and update the inventory of the product
      accordingly.
4. It is important to process the invoices in the order they appear in the CSV.
5. Print a list of invoices listing the problematic line(s) for each invoice.

### 📗 Chapter 4.0

1. Read a CSV file into memory which contains product inventory.
2. Read a CSV file into memory which contain sales invoice lines, where each invoice has a timestamp denoting the transaction date and time.
3. Check if the product referenced on each line has enough inventory.
   1. If no, do not import the invoice to which the line belongs.
   2. If yes, import the invoice line and update the inventory of the product
      accordingly.
4. It is important to process any given invoice only once all the other invoices with earlier timestamps have been processed.
5. Print a list of invoices listing the problematic line(s) for each invoice.

### 📗 Chapter 5.0

1. Read a CSV file into memory which contains product inventory.
2. Read two CSV files into memory, one containing sales invoice lines and the other purchase invoice lines. Each invoice has a timestamp which denotes the transaction date and time.
3. Check if the product referenced on each sales invoice line has enough inventory.
   1. If no, do not import the sales invoice to which the line belongs.
   2. If yes, import the invoice line and update the inventory of the product
      accordingly.
4. It is important to process any given invoice only once all the other invoices (sales and purchase) with earlier timestamps have been processed.
5. Print a list of sales invoices listing the problematic line(s) for each invoice.
