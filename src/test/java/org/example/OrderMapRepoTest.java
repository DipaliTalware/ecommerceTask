package org.example;

import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapRepoTest {

    @org.junit.jupiter.api.Test
    void addOrder() {
//        Given
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        Order order = new Order("1", 2, 2, "dummy", 12);
//        when
        orderMapRepo.addOrder(order);
//        then
       List<Order> orders = orderMapRepo.getAllOrders();
        assertNotNull(orders);
        Assertions.assertEquals(1, orders.size());
    }

    @org.junit.jupiter.api.Test
    void removeOrder() {
        //        Given
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        Order order = new Order("1", 2, 2, "dummy", 12);
        orderMapRepo.addOrder(order);
//        when
        orderMapRepo.removeOrder(order);
//        then
        List<Order> orders = orderMapRepo.getAllOrders();
        Assertions.assertEquals(0, orders.size());
    }

    @org.junit.jupiter.api.Test
    void removeNonExistingOrder(){
        //        Given
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        Order order = new Order("1", 2, 2, "dummy", 12);
        Order order2 = new Order("5", 6, 6, "dummy2", 12);
        orderMapRepo.addOrder(order);
//        when
        orderMapRepo.removeOrder(order2);
//        then
        List<Order> orders = orderMapRepo.getAllOrders();
        Assertions.assertEquals(1, orders.size());
    }

    @org.junit.jupiter.api.Test
    void getOrder() {
    }

    @org.junit.jupiter.api.Test
    void getAllOrders() {
    }
}