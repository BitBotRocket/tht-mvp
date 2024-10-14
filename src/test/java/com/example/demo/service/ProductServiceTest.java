package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductDatabase productDatabase;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product("1", "Product1", 100);
        when(productDatabase.store(product)).thenReturn(product);

        Product createdProduct = productService.createProduct(product);

        assertNotNull(createdProduct);
        assertEquals("1", createdProduct.getId());
        assertEquals("Product1", createdProduct.getName());
        assertEquals(100, createdProduct.getPrice());
        verify(productDatabase, times(1)).store(product);
    }

    @Test
    public void testRetrieveAllProducts() {
        Product product1 = new Product("1", "Product1", 100);
        Product product2 = new Product("2", "Product2", 200);
        List<Product> productList = Arrays.asList(product1, product2);
        when(productDatabase.retrieveAll()).thenReturn(productList);

        List<Product> retrievedProducts = productService.retrieveAllProducts();

        assertNotNull(retrievedProducts);
        assertEquals(2, retrievedProducts.size());
        assertEquals("1", retrievedProducts.get(0).getId());
        assertEquals("Product1", retrievedProducts.get(0).getName());
        assertEquals(100, retrievedProducts.get(0).getPrice());
        assertEquals("2", retrievedProducts.get(1).getId());
        assertEquals("Product2", retrievedProducts.get(1).getName());
        assertEquals(200, retrievedProducts.get(1).getPrice());
        verify(productDatabase, times(1)).retrieveAll();
    }

    @Test
    public void testRetrieveProductById() {
        Product product = new Product("1", "Product1", 100);
        when(productDatabase.retrieve("1")).thenReturn(product);

        Product retrievedProduct = productService.retrieveProductById("1");

        assertNotNull(retrievedProduct);
        assertEquals("1", retrievedProduct.getId());
        assertEquals("Product1", retrievedProduct.getName());
        assertEquals(100, retrievedProduct.getPrice());
        verify(productDatabase, times(1)).retrieve("1");
    }

    @Test
    public void testClearAllProducts() {
        doNothing().when(productDatabase).clear();

        productService.clearAllProducts();

        verify(productDatabase, times(1)).clear();
    }
}