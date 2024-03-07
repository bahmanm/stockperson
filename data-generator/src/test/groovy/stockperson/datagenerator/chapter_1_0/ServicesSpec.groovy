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
import stockperson.datagenerator.chapter_1_0.Services.*

class ServicesSpec extends Specification {

  def 'ProductService.make'() {
    given:
    def minCount = 10
    def maxCount = 50
    def products = ProductService.instance.make(minCount, maxCount)

    expect:
    products.size() < maxCount && products.size() >= minCount
    products == products.toUnique { p1, p2 ->
      p1.name <=> p2.name
    }
  }
}
