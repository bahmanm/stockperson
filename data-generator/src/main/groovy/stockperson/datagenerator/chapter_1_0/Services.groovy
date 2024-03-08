/*
 * Copyright (c) Bahman Movaqar and contributors
 *
 * This file is part of StockPerson DataGenerator.
 *
 * StockPerson DataGenerator is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * StockPerson DataGenerator is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with StockPerson DataGenerator. If not, see <https://www.gnu.org/licenses/>.
 */
package stockperson.datagenerator.chapter_1_0

import stockperson.datagenerator.chapter_1_0.Helpers.*
import stockperson.datagenerator.chapter_1_0.Models.*

/**
 * A service to generate instances of Product.
 */
@Singleton
class ProductService {

  Product make() {
    def name = RandomString.instance.alphanumeric(1, 8)
    def price = RandomNumber.instance.aBigDecimal(0.1, 100_000)
    new Product(name: name, price: price)
  }

  List<Product> make(Integer minCountInclusive, Integer maxCountExclusive) {
    int count = RandomNumber.instance.anInt(minCountInclusive, maxCountExclusive)
    def result = (1..count).collect {
      make()
    }.unique()

    if (result.size() >= minCountInclusive)
      result
    else
      result + make(minCountInclusive, count - result.size())
  }
}

/**
 * A service to generate invoices.
 */
@Singleton
class InvoiceService {

  Invoice make(List<Product> allProducts, List<String> customers) {
    new Invoice(
        docNo: RandomString.instance.alphanumeric(6, 7),
        date: new Date(),
        customer: RandomList.instance.subList(customers, 1)[0],
        discount: RandomNumber.instance.aBigDecimal(0, 75),
        lines: makeLines(allProducts)
        )
  }

  List<Invoice> make(List<Product> allProducts, List<String> customers, Integer count) {
    def result = (1..count).collect {
      make(allProducts, customers)
    }.unique()

    if (result.size() >= count)
      result
    else
      result + make(allProducts, customers, count - result.size())
  }

  List<InvoiceLine> makeLines(List<Product> allProducts) {
    def count = RandomNumber.instance.anInt(1, allProducts.size())
    def products = RandomList.instance.subList(allProducts, count)
    (0..count).collect { i ->
      new InvoiceLine(lineNo: i+1, product: products[i], qty: RandomNumber.instance.anInt(1, 1000))
    }
  }
}
