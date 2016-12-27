package stockman.datagen.services

import stockman.datagen.models.Product
import static stockman.datagen.helpers.RandomHelper.*

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
