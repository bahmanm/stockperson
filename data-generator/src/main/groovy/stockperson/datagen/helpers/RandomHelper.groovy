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
package stockperson.datagen.helpers

import java.math.*

/**
 * @author Bahman Movaqar <Bahman AT BahmanM.com>
 */
class RandomHelper {

	static private random = new Random()

	static private Random r() {
		random.setSeed(System.nanoTime())
		random
	}

	static List genList(List inList, Integer len) {
		(1..len).collect {
			inList[r().nextInt(inList.size())]
		}
	}

	static BigDecimal genPrice() {
		new BigDecimal(
				r().nextDouble() * (10 ** r().nextInt(4))
				).setScale(2, RoundingMode.HALF_UP)
	}

	static BigDecimal genPrice(
			BigDecimal orig,
			Number minDiffPercent, Number maxDiffPercent
	) {
		def diff = (
				r().nextInt(minDiffPercent + maxDiffPercent)
				- minDiffPercent
				+ r().nextDouble()
				) / 100.0
		new BigDecimal(
				orig + (orig * diff)
				).setScale(2, RoundingMode.HALF_UP)
	}

	static Integer genQty(Integer max) {
		r().nextInt(max)
	}

	static Integer genQty(Integer orig, Integer maxPercent) {
		def diff = (
				r().nextInt(maxPercent)
				+ r().nextDouble()
				) / 100.0
		new BigDecimal(
				orig * diff
				).setScale(0, RoundingMode.HALF_UP)
	}

	static <T> T pick(List<T> inList) {
		inList.sort(false) { new Random() }[0]
	}

	static Date genDate(Integer minDiff, Integer maxDiff) {
		def diff = r().nextInt(minDiff + maxDiff) - minDiff
		new Date() + diff
	}
}
