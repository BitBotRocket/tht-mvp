
package com.example.demo.repository;


import com.example.demo.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductDatabaseTest {

    private ProductDatabase productDatabase;

    @BeforeEach
    public void setUp() {
        productDatabase = new ProductDatabase();
    }

    @Test
    public void testStoreAndRetrieve() {
        Product product = new Product();
        product.setName("Test Product");

        Product storedProduct = productDatabase.store(product);
        assertNotNull(storedProduct.getId());

        Product retrievedProduct = productDatabase.retrieve(storedProduct.getId());
        assertNotNull(retrievedProduct);
        assertEquals("Test Product", retrievedProduct.getName());
    }

    @Test
    public void testStoreWithKeyAndRetrieve() {
        Product product = new Product();
        product.setName("Test Product");

        String key = "customKey";
        productDatabase.store(key, product);

        Product retrievedProduct = productDatabase.retrieve(key);
        assertNotNull(retrievedProduct);
        assertEquals("Test Product", retrievedProduct.getName());
    }

    @Test
    public void testRetrieveAll() {
        Product product1 = new Product();
        product1.setName("Product 1");
        productDatabase.store(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        productDatabase.store(product2);

        List<Product> products = productDatabase.retrieveAll();
        assertEquals(2, products.size());
    }

    @Test
    public void testClear() {
        Product product = new Product();
        product.setName("Test Product");
        productDatabase.store(product);

        productDatabase.clear();

        List<Product> products = productDatabase.retrieveAll();
        assertTrue(products.isEmpty());
    }
}