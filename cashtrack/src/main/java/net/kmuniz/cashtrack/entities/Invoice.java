package net.kmuniz.cashtrack.entities;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Value
@AllArgsConstructor
@Document(collection="invoices")
public class Invoice {
    @Id
    @NonFinal
    String invoiceId;
    String userId;
    String customerId;
    Date issuedDate;
    Date dueDate;
    BigDecimal subtotal;
    BigDecimal total;
    double tax;
    Set<Item> items;
}
