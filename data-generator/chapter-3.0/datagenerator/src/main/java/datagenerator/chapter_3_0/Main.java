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
import java.util.stream.IntStream;

public class Main {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
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

    System.out.print(
        """
    # Produced using StockPerson Data Generator (chapter 1.0)
    # https://github.com/bahmanm/stockperson/
    # product,qty
    """);
    products.forEach(p -> System.out.printf("%s,%.2f\n", p.getCode(), p.getQty()));
    System.out.println();

    System.out.print(
        """
    # Produced using StockPerson Data Generator (chapter 3.0)
    # https://github.com/bahmanm/stockperson/
    # docNo,supplier,date,total,discount,lineNo,product,qty,price,lineAmt
    """);
    purchaseInvoices.forEach(System.out::println);
    System.out.println();

    System.out.print(
        """
    # Produced using StockPerson Data Generator (chapter 3.0)
    # https://github.com/bahmanm/stockperson/
    # docNo,customer,date,total,discount,lineNo,product,qty,price,lineAmt
    """);
    salesInvoices.forEach(System.out::println);
  }
}
