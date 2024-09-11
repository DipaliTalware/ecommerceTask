package org.example;

import java.util.*;

public class OrderMapRepo implements OrderRepo {

    private final Map<String, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        this.orders.put(order.orderId(), order);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order.orderId());
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public List<Order> getAllOrders() {
        return orders.values().stream().toList();
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }
}
