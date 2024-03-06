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
package stockperson.datagenerator

import stockperson.datagenerator.services.Invoices
import stockperson.datagenerator.services.Products

/**
 * @author Bahman Movaqar <Bahman AT BahmanM.com>
 */
class Main {

	static Integer dummyMethod(Integer i) {
		i * i
	}

	static void main(String[] args) {
		new File('products.csv').withWriter {
			it << Products.instance.genProducts().toCsv(true)
		}
		new File('invoices.csv').withWriter {
			it << Invoices.instance.genInvoices().toCsv(true)
		}
	}
}
