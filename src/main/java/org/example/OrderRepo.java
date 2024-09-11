package org.example;

import java.util.List;

public interface OrderRepo {
    void addOrder(Order order);

    void removeOrder(Order order);

    Order getOrder(String orderId);

    List<Order> getAllOrders();
}
