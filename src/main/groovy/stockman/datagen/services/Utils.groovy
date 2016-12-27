package stockman.datagen.services

import java.math.*

/**
 * @author Bahman Movaqar <Bahman AT BahmanM.com>
 */
class Utils {

  static private random = new Random()

  static private Random r() {
    random.setSeed(System.nanoTime())
    random
  }

  static List genRandomList(List inList, Integer len) {
    (1..len).collect {
      inList[r().nextInt(inList.size())]
    }
  }

  static BigDecimal genPrice() {
    new BigDecimal(
      r().nextDouble() * (10 ** r().nextInt(4))
    ).setScale(2, RoundingMode.HALF_UP)
  }

  static Integer genQty(Integer max) {
    r().nextInt(max)
  }

}
