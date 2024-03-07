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

@Singleton
class RandomNumber {

  java.util.Random rand = new java.util.Random()

  Integer anInt(Integer fromInclusive = 0, Integer toExclusive = 1_000) {
    rand.ints(fromInclusive, toExclusive).findFirst().getAsInt()
  }

  BigDecimal aBigDecimal(BigDecimal fromInclusive = 0.0, BigDecimal toExclusive = 1_000_000.0) {
    rand.doubles(fromInclusive, toExclusive).findFirst().getAsDouble() as BigDecimal
  }
}
