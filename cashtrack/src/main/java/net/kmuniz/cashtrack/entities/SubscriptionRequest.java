package net.kmuniz.cashtrack.entities;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class SubscriptionRequest {
    @NonNull String userId;
    @NonNull String token;
    @NonNull String tier;
}
