package stockman.datagen.services

import stockman.datagen.models.Product
import static stockman.datagen.services.Utils.*

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
    count: 5
  ]

  @Delegate(interfaces = false)
  List<Product> products = []

  Products genProducts() {
    products = (1..config.count).collect { genProduct() }
    this
  }

  Product genProduct() {
    new Product(
      name: config.name.suffix + genRandomList(
        config.name.seed, config.name.len
      ).join(''),
      qty: genQty(config.qty.max),
      price: genPrice()
    )
  }

  String toCsv() {
    'name,qty\n' +
      products
        .collect { "${it.name},${it.qty}" }
        .join('\n')
  }

}
