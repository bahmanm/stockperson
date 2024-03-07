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

class HelpersSpec extends Specification {

  def 'RandomNumber.anInt'(def lowerBound, def upperBound) {
    expect:
    RandomNumber.instance.anInt(lowerBound, upperBound) < upperBound
    RandomNumber.instance.anInt(lowerBound, upperBound) >= lowerBound

    where:
    lowerBound << [1, -5, -100, 1000, 1_000_000]
    upperBound << [
      10,
      100,
      500,
      20_000,
      1_000_999
    ]
  }

  def 'RandomNumber.aBigDecimal'(def lowerBound, def upperBound) {
    expect:
    RandomNumber.instance.aBigDecimal(lowerBound, upperBound) < upperBound
    RandomNumber.instance.aBigDecimal(lowerBound, upperBound) >= lowerBound

    where:
    lowerBound << [
      1.0,
      -5.0,
      -100.0,
      1000.0,
      1_000_000.0
    ]
    upperBound << [
      100.0,
      1000.0,
      5000.0,
      200_000.0,
      1_900_999.0
    ]
  }

  def 'RandomString.alphanumeric'(def str, def minLen, def maxLen) {
    expect:
    str =~ /[\da-zA-Z]+/
    str.length() >= minLen
    str.length() < maxLen

    where:
    minLen = 5
    maxLen = 18
    str = RandomString.instance.alphanumeric(minLen, maxLen)
  }

  def 'RandomString.alphabetic'(def str) {
    expect:
    str =~ /[a-zA-Z]+/
    str.length() >= minLen
    str.length() < maxLen

    where:
    minLen = 5
    maxLen = 18
    str = RandomString.instance.alphabetic(minLen, maxLen)
  }
}
