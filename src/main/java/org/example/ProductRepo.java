package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products = new ArrayList<>();

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

//    to add single product in to List
    public void addProduct(Product product) {
        products.add(product);
    }

//    to remove single product from the list
    public void removeProduct(Product product){
        products.remove(product);
    }

//    to get single product
    public Product getProduct(int productId){
        for (Product product: products){
            if(product.productId()==(productId)){
                return product;
            }
        }
        return null;
    }

//    to get all products
    public List<Product> getAllProducts(){
        return products;
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
