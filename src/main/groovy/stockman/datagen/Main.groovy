package stockman.datagen

import stockman.datagen.services.Products
import stockman.datagen.services.Invoices

/**
 * @author Bahman Movaqar <Bahman AT BahmanM.com>
 */
class Main {

  static void main(String[] args) {
    println Products.instance.genProducts().toCsv(true)
    println Invoices.instance.genInvoices().toCsv(true)
  }

}
