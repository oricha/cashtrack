package net.kmuniz.cashtrack.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.math.BigDecimal;

@Value
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item implements Comparable<Item>{
    @EqualsAndHashCode.Include int position;
    String description;
    BigDecimal rate;
    long quantity;
    @Override
    public int compareTo(Item o) {
        return Integer.valueOf(this.position)
                .compareTo(Integer.valueOf(o.getPosition()));
    }
}
