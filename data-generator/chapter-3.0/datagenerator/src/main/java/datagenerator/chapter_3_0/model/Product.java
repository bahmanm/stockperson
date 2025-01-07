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

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

@Getter
@Builder
public class Product {

  private String code;
  private Double qty;

  private Product(String code, Double qty) {
    this.code = code;
    this.qty = qty;
  }

  public static Product generate() {
    return Product.builder()
        .code(RandomStringUtils.insecure().nextAlphanumeric(10))
        .qty(RandomUtils.insecure().randomDouble(1d, 10_000d))
        .build();
  }

  @Override
  public String toString() {
    return code;
  }
}
