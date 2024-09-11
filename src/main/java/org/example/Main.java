package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Product> products = new HashMap<>();
        products.put(1, new Product(1, "Nike Shoes", 100, 4));
        products.put(2, new Product(2, "T Shirt", 120, 10));
        products.put(3, new Product(3, "Levis Jeans", 120, 15));
        products.put(4, new Product(4, "Shorts", 20, 5));
        products.put(5, new Product(5, "Columbia Winter Jacket", 300, 7));

        ProductRepo productRepo = new ProductRepo(products);

        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.placeOrder(1, 1, "Jon Doe");
        shopService.placeOrder(4, 3, "Jonny");

        shopService.editOrder(2, "4edd1efa-85fb-41bf-8bc1-b6176060071c");

        System.out.println(shopService);
    }
}