package com.example.payments;

import java.util.Map;
import java.util.Objects;

public class OrderService {
    private final PaymentGateway gateway;

    public OrderService(PaymentGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway, "gateway must not be null");
    }

    // Smell: still switches; your refactor should remove this by ensuring map contains adapters.
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId must not be null");
        return gateway.charge(customerId, amountCents);
    }
}
