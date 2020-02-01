package net.kmuniz.cashtrack.entities;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Value
@AllArgsConstructor
@Document(collection="subscriptions")
public class Subscription {
    @Id
    @NonFinal
    String subscriptionId;
    String providerId;
    String userId;
    String tier;
    LocalDate startedDate;
}
