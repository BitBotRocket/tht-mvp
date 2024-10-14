package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductDatabase;
import java.util.List;
import java.util.ArrayList;

@Service
public class ProductService {

    private final ProductDatabase productDatabase;

    @Autowired
    public ProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public Product createProduct(Product product) {
        return productDatabase.store(product);
    }

    public List<Product> retrieveAllProducts() {
        final List<Product> products = new ArrayList<>();
        products.addAll(productDatabase.retrieveAll());
        return products;
    }

    public Product retrieveProductById(String id) {
        return productDatabase.retrieve(id);
    }

    public void clearAllProducts() {
        productDatabase.clear();
    }

}