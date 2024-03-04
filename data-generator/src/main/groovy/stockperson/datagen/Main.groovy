package stockperson.datagen

import stockperson.datagen.services.Products
import stockperson.datagen.services.Invoices

/**
 * @author Bahman Movaqar <Bahman AT BahmanM.com>
 */
class Main {

  static void main(String[] args) {
    new File('products.csv').withWriter {
      it << Products.instance.genProducts().toCsv(true)
    }
    new File('invoices.csv').withWriter {
      it << Invoices.instance.genInvoices().toCsv(true)
    }
  }

}
