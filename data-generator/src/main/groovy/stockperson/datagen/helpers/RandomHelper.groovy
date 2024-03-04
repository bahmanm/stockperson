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
