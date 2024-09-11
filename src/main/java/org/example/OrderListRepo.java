package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo implements OrderRepo{
    private List<Order> orders = new ArrayList<>();

    public OrderListRepo(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public void removeOrder(Order order){
        this.orders.remove(order);
    }

    public Order getOrder(String orderId){
        for (Order order :orders){
            if(Objects.equals(order.orderId(), orderId)){
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders(){
        return orders;
    }
}
