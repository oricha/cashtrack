package net.kmuniz.cashtrack.entities;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Address {

    String city;
    String postalCode;
    String addressLine;
}
