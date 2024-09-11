package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo {
    private Map<Integer, Product> products = new HashMap<>();

    public ProductRepo(Map<Integer,Product> products) {
        this.products = products;
    }

//    to add single product in to List
    public void addProduct(Product product) {
        products.put(product.productId(), product);
    }

//    to remove single product from the list
    public void removeProduct(Product product){
        products.remove(product.productId());
    }

//    to get single product
    public Product getProduct(int productId){
        return products.get(productId);
    }

//    to get all products
    public List<Product> getAllProducts(){
        return products.values().stream().toList();
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
