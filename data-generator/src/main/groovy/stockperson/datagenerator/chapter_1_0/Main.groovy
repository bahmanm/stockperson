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

import groovy.cli.picocli.CliBuilder
import stockperson.datagenerator.chapter_1_0.Helpers.*
import stockperson.datagenerator.chapter_1_0.Services.*

class Main {

  static CliBuilder cli

  static {
    cli = new CliBuilder(
        header: 'StockPerson Data Generator - Chapter 1.0',
        usage: 'Main [OPTION1] [OPTION2] ...'
        )
    cli._(longOpt: 'invoice-count', args: 1, argName: 'N', required: true,
    'How many invoices to generate?')
  }

  static void main(String[] args) {
    def options = cli.parse(args); assert options

    def countProducts = RandomNumber.instance.anInt(10, 50)
    def countCustomers = RandomNumber.instance.anInt(10, 100)
    def countInvoices = options.'invoice-count'
        ? options.'invoice-count' as Integer
        : RandomNumber.instance.anInt(10, 100)

    def products = ProductService.instance.make(RandomNumber.instance.anInt(countProducts))
    def customers = (0..10).collect { RandomString.instance.alphabetic(5, 10) }
    def invoices = InvoiceService.instance.make(products, customers, countInvoices)

    invoices.each { inv ->
      println(InvoiceService.instance.toCsv(inv).join('\n'))
    }
  }
}
