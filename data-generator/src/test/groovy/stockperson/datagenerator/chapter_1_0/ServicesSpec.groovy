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

import spock.lang.*
import stockperson.datagenerator.chapter_1_0.Helpers.*
import stockperson.datagenerator.chapter_1_0.Models.*
import stockperson.datagenerator.chapter_1_0.Services.*

class ServicesSpec extends Specification {

  def 'ProductService.make'() {
    given:
    def count = RandomNumber.instance.anInt(10, 100)
    def products = ProductService.instance.make(count)

    expect:
    products.size() == count
    products == products.toUnique { p1, p2 ->
      p1.name <=> p2.name
    }
  }

  def 'InvoiceService.make single'() {
    given:
    def products = ProductService.instance.make(RandomNumber.instance.anInt(10, 100))
    def customers = (0..10).collect { RandomString.instance.alphabetic(3, 8) }
    def invoice = InvoiceService.instance.make(products, customers)

    expect:
    invoice.customer in customers
    !invoice.lines.empty
    invoice.lines*.product.every { p -> p in products }
  }

  def 'InvoiceService.make list'() {
    given:
    def count = RandomNumber.instance.anInt(5, 50)
    def products = ProductService.instance.make(count)
    def customers = (0..10).collect { RandomString.instance.alphabetic(3, 8) }
    def invoices = InvoiceService.instance.make(products, customers, count)

    expect:
    invoices.size() == count
    invoices*.customer.every { c -> c in customers }
    invoices*.lines.every { lines -> !lines.empty }
    invoices*.lines*.product.flatten().every { p -> p in products }
  }
}
