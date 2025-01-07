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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

@Builder
@Getter
public class SalesInvoice {

  private String docNo;
  private Customer customer;
  private Date date;
  private Double discount;
  private List<InvoiceLine> lines;

  public SalesInvoice(
      String docNo, Customer customer, Date date, Double discount, List<InvoiceLine> lines) {
    this.docNo = docNo;
    this.customer = customer;
    this.date = date;
    this.discount = discount;
    this.lines = lines;
  }

  public Double getTotal() {
    return lines.stream().mapToDouble(InvoiceLine::getTotal).sum() * (100d - discount);
  }

  private static Date generateDate() {
    var cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR, RandomUtils.insecure().randomInt(0, 1000));
    return cal.getTime();
  }

  public static SalesInvoice generate(List<Product> products, List<Customer> customers) {
    var lines = new ArrayList<InvoiceLine>();
    for (var i = 1; i < RandomUtils.insecure().randomInt(1, 50); i++) {
      lines.add(InvoiceLine.generate(i, products));
    }
    return SalesInvoice.builder()
        .customer(customers.get(RandomUtils.insecure().randomInt(0, customers.size() - 1)))
        .date(generateDate())
        .discount(RandomUtils.insecure().randomDouble(0, 60d))
        .docNo(RandomStringUtils.insecure().nextAlphanumeric(10))
        .lines(lines)
        .build();
  }

  @Override
  public String toString() {
    var headerString =
        "%s,%s,%s,%.2f,%.2f"
            .formatted(
                docNo,
                customer,
                new SimpleDateFormat("yyyy-MM-dd").format(date),
                discount,
                getTotal());
    var sb = new StringBuilder();
    lines.forEach(
        (line) -> {
          sb.append(headerString);
          sb.append(line);
          sb.append("\n");
        });
    return sb.toString().trim();
  }
}