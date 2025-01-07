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

@Getter
@Builder
public class Supplier {

  private String name;

  private Supplier(String name) {
    this.name = name;
  }

  public static Supplier generate() {
    return Supplier.builder().name(RandomStringUtils.insecure().nextAlphanumeric(10)).build();
  }

  @Override
  public String toString() {
    return name;
  }
}
