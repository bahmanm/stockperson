/*
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
package stockperson.datagen.services

import static stockperson.datagen.helpers.RandomHelper.*

import stockperson.datagen.models.Invoice
import stockperson.datagen.models.InvoiceLine

/**
 * @author Bahman Movaqar <Bahman AT BahmanM.com>
 */
@Singleton
class Invoices {

	Map config = [
		docNo: [
			suffix: 'SI-',
			seed: '0'..'9',
			len: 4
		],
		customer: [
			suffix: 'S-',
			seed: '0'..'9',
			len: 4
		],
		date: [
			minDiff: 100,
			maxDiff: 100,
			format: 'YYYY/MM/dd'
		],
		count: 10,
		line: [
			qty: [
				maxPercent: 60
			],
			price: [
				minDiffPercent: 20,
				maxDiffPercent: 20,
			],
			count: 6
		]
	]

	@Delegate(interfaces = false)
	List<Invoice> invoices = []

	Invoices genInvoices() {
		invoices = (0..config.count).collect { genInvoice() }
		this
	}

	Invoice genInvoice() {
		new Invoice(
				docNo: config.docNo.suffix + genList(
				config.docNo.seed, config.docNo.len
				).join(''),
				date: genDate(config.date.minDiff, config.date.maxDiff),
				customer: config.customer.suffix + genList(
				config.customer.seed, config.customer.len
				).join(''),
				lines: genLines()
				)
	}

	List<InvoiceLine> genLines() {
		def nLines = new Random().nextInt(config.line.count)
		def lines = []
		while (lines.size() < nLines) {
			def line = genInvoiceLine()
			if (!lines*.product.contains(line.product) &&
					line.qty > 0 &&
					line.price > 0) {
				line.lineNo = lines.size() + 1
				lines << line
			}
		}
		lines
	}

	InvoiceLine genInvoiceLine() {
		def product = pick(Products.instance as List)
		new InvoiceLine(
				product: product.name,
				qty: genQty(product.qty, config.line.qty.maxPercent),
				price: genPrice(
				product.price,
				config.line.price.minDiffPercent,
				config.line.price.maxDiffPercent
				)
				)
	}

	String toCsv(Boolean shuffle) {
		def allAsLines = invoices.collect { invoice ->
			def hdrInfo = String.format(
					'%s,%s,%s',
					invoice.docNo,
					invoice.date.format(config.date.format),
					invoice.customer
					)
			invoice.lines.collect { line ->
				String.format(
						'%s,%d,%s,%d,%.2f',
						hdrInfo,
						line.lineNo,
						line.product,
						line.qty,
						line.price
						)
			}
		}.flatten()
		'docNo,docDate,customer,lineNo,product,qty,price\n' +
				(shuffle ? allAsLines.sort { new Random() } : allAsLines).join('\n')
	}

	List asType(List) {
		return invoices
	}
}
