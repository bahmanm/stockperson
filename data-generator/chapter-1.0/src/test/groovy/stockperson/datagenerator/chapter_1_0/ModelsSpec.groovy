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
import stockperson.datagenerator.chapter_1_0.Models.*

class ModelsSpec extends Specification {

  def 'InvoiceLine#getLineAmt'() {
    given:
    def prod1 = new Product(name: 'p1', price: 100.0)
    def prod2 = new Product(name: 'p2', price: 200.0)

    def line1 = new InvoiceLine(lineNo: 1, product: prod1, qty: 5)
    def line2 = new InvoiceLine(lineNo: 1, product: prod2, qty: 3)

    expect:
    line1.lineAmt == 500.0
    line2.lineAmt == 600.0
  }

  def 'Invoice#getTotal'() {
    given:
    def prod1 = new Product(name: 'p1', price: 10.0)
    def prod2 = new Product(name: 'p2', price: 200.0)

    def inv1 = new Invoice(
        docNo: 's10', date: new Date(), customer: 'c1', discount: 12.0,
        lines: [
          new InvoiceLine(lineNo: 1, product: prod1, qty: 10)
        ]
        )
    def inv2 = new Invoice(
        docNo: 's20', date: new Date(), customer: 'c2', discount: 25.0,
        lines: [
          new InvoiceLine(lineNo: 1, product: prod1, qty: 20),
          new InvoiceLine(lineNo: 2, product: prod2, qty: 3)
        ]
        )

    expect:
    inv1.total == 88.0
    inv2.total == 600.0
  }
}
