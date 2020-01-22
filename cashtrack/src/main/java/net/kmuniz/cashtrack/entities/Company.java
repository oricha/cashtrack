package net.kmuniz.cashtrack.entities;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@AllArgsConstructor
@Document(collection="companies")
public class Company {
    @Id
    String companyId;
    String userId;
    String name;
    String type;
    String taxId;
    Address address;
}
