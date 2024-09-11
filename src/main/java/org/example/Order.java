package org.example;

import java.util.Objects;

public record Order(String orderId, int productId, int quantity, String customerName, double totalPrice) {
}
