package org.example;


public record Order(String orderId, int productId, int quantity, String customerName, double totalPrice) {
}
