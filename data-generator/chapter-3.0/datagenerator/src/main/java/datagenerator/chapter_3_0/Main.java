/*
 * Copyright 2025 Bahman Movaqar
 *
 * This file is part of StockPerson.
 *
 * StockPerson is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * StockPerson is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with StockPerson. If not, see <https://www.gnu.org/licenses/>.
 */
package datagenerator.chapter_3_0;

import datagenerator.chapter_3_0.model.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
  
  public static void main(String[] args) throws IOException {
    if (args.length < 5) {
      System.out.println("USAGE: nProducts nCustomers nSuppliers nPurchaseInvoices nSalesInvoices");
      System.exit(0);
    }
    var products =
        IntStream.range(0, Integer.parseInt(args[0])).mapToObj((i) -> Product.generate()).toList();
    var customers =
        IntStream.range(0, Integer.parseInt(args[1])).mapToObj((i) -> Customer.generate()).toList();
    var suppliers =
        IntStream.range(0, Integer.parseInt(args[2])).mapToObj((i) -> Supplier.generate()).toList();

    var purchaseInvoices =
        IntStream.range(0, Integer.parseInt(args[3]))
            .mapToObj((i) -> PurchaseInvoice.generate(products, suppliers))
            .toList();
    var salesInvoices =
        IntStream.range(0, Integer.parseInt(args[4]))
            .mapToObj((i) -> SalesInvoice.generate(products, customers))
            .toList();

    writeProducts(products);
    writePurchaseInvoices(purchaseInvoices);
    writeSalesInvoices(salesInvoices);
  }

  private static void writeSalesInvoices(List<SalesInvoice> invoices) throws IOException {
    var writer = new BufferedWriter(new FileWriter(new File("sales-invoices.csv")));
    writer.write(
        """
        # Produced using StockPerson Data Generator (chapter 3.0)
        # https://github.com/bahmanm/stockperson/
        # docNo,customer,date,total,discount,lineNo,product,qty,price,lineAmt
        """);
    for (var i : invoices) {
      writer.write(i.toString());
      writer.newLine();
    }
    writer.close();
  }

  private static void writePurchaseInvoices(List<PurchaseInvoice> invoices) throws IOException {
    var writer = new BufferedWriter(new FileWriter(new File("purchase-invoices.csv")));
    writer.write(
        """
    # Produced using StockPerson Data Generator (chapter 3.0)
    # https://github.com/bahmanm/stockperson/
    # docNo,supplier,date,total,discount,lineNo,product,qty,price,lineAmt
    """);
    for (var i : invoices) {
      writer.write(i.toString());
      writer.newLine();
    }
    writer.close();
  }

  private static void writeProducts(List<Product> products) throws IOException {
    var writer = new BufferedWriter(new FileWriter(new File("products.csv")));
    writer.write(
        """
                      # Produced using StockPerson Data Generator (chapter 3.0)
                      # https://github.com/bahmanm/stockperson/
                      # product,qty
                      """);
    for (var p : products) {
      writer.write("%s,%.2f\n".formatted(p.getCode(), p.getQty()));
    }
    writer.newLine();
    writer.flush();
    writer.close();
  }
}
