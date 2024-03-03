package stockman.datagen.models

/**
 * @author Bahman Movaqar <Bahman AT BahmanM.com>
 */
class Invoice {

  String docNo
  Date date
  String customer
  List<InvoiceLine> lines

  BigDecimal getTotal() {
    lines?.reduce(0.0) { sum, line -> sum + line.price }
  }

}
