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

import stockperson.datagen.models.Product

/**
 * @author Bahman Movaqar <Bahman AT BahmanM.com>
 */
@Singleton
class Products {

	Map config = [
		name: [
			suffix: 'P-',
			seed: '0'..'9',
			len: 4
		],
		qty: [
			max: 10_000
		],
		count: 20
	]

	@Delegate(interfaces = false)
	List<Product> products = []

	Products genProducts() {
		products = (1..config.count).collect { genProduct() }
		this
	}

	Product genProduct() {
		new Product(
				name: config.name.suffix + genList(
				config.name.seed, config.name.len
				).join(''),
				qty: genQty(config.qty.max),
				price: genPrice()
				)
	}

	String toCsv(Boolean shuffle=true) {
		def allAsLines = products.collect { "${it.name},${it.qty},${it.price}" }
		'name,qty,price\n' +
				(shuffle ? allAsLines.sort { new Random() } : allAsLines).join('\n')
	}

	List asType(List) {
		products
	}
}
