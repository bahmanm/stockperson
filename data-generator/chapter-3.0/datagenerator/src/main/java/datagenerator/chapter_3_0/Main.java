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
package datagenerator.chapter_3_0;

public class Main {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    System.out.println(new Main().getGreeting());
  }
}
