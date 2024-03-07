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

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

/**
 * A sales invoice.
 */
@TupleConstructor
@EqualsAndHashCode(excludes = ['date', 'discount', 'lines'])
class Invoice {

  String docNo
  Date date
  String customer
  BigDecimal discount
  List<InvoiceLine> lines

  BigDecimal getTotal() {
    lines*.lineAmt.sum() * ((100.0 - discount) / 100.0)
  }

  List<String> toCsvRows() {
    lines.collect { line ->
      [
        docNo,
        customer,
        date,
        total,
        discount,
        line.lineNo,
        line.product?.name,
        line.qty,
        line.product?.price,
        line.lineAmt
      ].join(',')
    }
  }
}

/**
 * A line in a sales invoice.
 */
@TupleConstructor
@EqualsAndHashCode(excludes = ['qty'])
class InvoiceLine {

  Integer lineNo
  Product product
  Integer qty

  BigDecimal getLineAmt() {
    product.price * qty
  }
}

/**
 * A product.
 */
@TupleConstructor
@EqualsAndHashCode(excludes = ['price'])
class Product {

  String name
  BigDecimal price
}
