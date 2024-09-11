package org.example;

import java.util.UUID;

public class ShopService {
    ProductRepo productRepo;
    OrderRepo orders;

    public ShopService(ProductRepo productRepo, OrderRepo orders) {
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
        double totalPrice = foundProduct.price() * quantity;
        Order order = new Order(generatedOrderId, productId, quantity, customerName, totalPrice);
        orders.addOrder(order);
        Product newProduct = new Product(foundProduct.productId(), foundProduct.name(), foundProduct.price(), foundProduct.quantity()-quantity);
        productRepo.addProduct(newProduct);
        return generatedOrderId;
    }

    public void editOrder(int newQuantity, String orderId) {
        Order foundOrder = orders.getOrder(orderId);

        if (foundOrder == null) {
            System.out.println("order not found");
            return;
        }

        int foundProductId = foundOrder.productId();
        Product foundProduct = productRepo.getProduct(foundProductId);
        double totalPrice = foundProduct.price() * newQuantity;

        Order editedOrder = new Order(foundOrder.orderId(), foundOrder.productId(), newQuantity, foundOrder.customerName(),totalPrice);
        Product newProduct = new Product(foundProduct.productId(), foundProduct.name(), foundProduct.price(), foundProduct.quantity()-newQuantity);
        productRepo.addProduct(newProduct);
        orders.addOrder(editedOrder);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orders=" + orders +
                '}';
    }
}
