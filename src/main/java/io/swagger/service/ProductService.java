package io.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.swagger.model.Product;
import io.swagger.model.Products;
import io.swagger.repository.ProductDatabase;

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

    public Products retrieveAllProducts() {
        Products products = new Products();
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