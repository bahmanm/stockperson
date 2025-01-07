/*
 * Copyright 2025 Bahman Movaqar
 *
 * This file is part of StockPerson.
 *
 * StockPerson is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * StockPerson is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with StockPerson. If not, see <https://www.gnu.org/licenses/>.
 */
package datagenerator.chapter_3_0.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.RandomUtils;

@Getter
@Builder
public class InvoiceLine {

  private Integer lineNo;
  private Product product;
  private Double qty;
  private Double price;

  private InvoiceLine(Integer lineNo, Product product, Double qty, Double price) {
    this.lineNo = lineNo;
    this.product = product;
    this.qty = qty;
    this.price = price;
  }

  public Double getTotal() {
    return qty * price;
  }

  public static InvoiceLine generate(Integer lineNo, List<Product> products) {
    return InvoiceLine.builder()
        .lineNo(lineNo)
        .product(products.get(RandomUtils.insecure().randomInt(0, products.size() - 1)))
        .qty(RandomUtils.insecure().randomDouble(0d, 10_000d))
        .price(RandomUtils.insecure().randomDouble(0d, 10_000d))
        .build();
  }

  @Override
  public String toString() {
    return "%d,%s,%.2f,%.2f,%.2f".formatted(lineNo, product, qty, price, getTotal());
  }
}
