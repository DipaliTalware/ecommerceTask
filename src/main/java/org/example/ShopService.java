package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopService {
    ProductRepo productRepo;
    OrderListRepo  orders = new OrderListRepo(new ArrayList<Order>());

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ShopService(ProductRepo productRepo, OrderListRepo orders) {
        this.productRepo = productRepo;
        this.orders = orders;
    }

    public String placeOrder(int productId, int quantity, String customerName) {
        Product foundProduct = productRepo.getProduct(productId);

        if (foundProduct == null) {
            System.out.println("product not found");
            return null;
        }

        if (foundProduct.quantity() < quantity) {
            System.out.println("quantity is not enough");
            return null;
        }

        String generatedOrderId = UUID.randomUUID().toString();
        Order newOrder = new Order(generatedOrderId, productId, quantity, customerName);
        return generatedOrderId;
    }
}
