package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.DiscountDatabase;
import com.example.demo.repository.ProductDatabase;
import com.example.demo.repository.entity.Discount;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class SalesServiceTest {

    @Mock
    private ProductDatabase productDatabase;

    @Mock
    private DiscountDatabase discountDatabase;

    @InjectMocks
    private SalesService salesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindMatchingProductsFromRequest() {
        Sale sale = new Sale();
        SaleItem item1 = new SaleItem();
        item1.setId("1");
        SaleItem item2 = new SaleItem();
        item2.setId("2");
        sale.setSaleItems(Arrays.asList(item1, item2));

        Product product1 = new Product();
        product1.setId("1");
        Product product2 = new Product();
        product2.setId("2");

        when(productDatabase.retrieve("1")).thenReturn(product1);
        when(productDatabase.retrieve("2")).thenReturn(product2);

        List<Product> products = salesService.findMatchingProductsFromRequest(sale);

        assertEquals(2, products.size());
        assertEquals("1", products.get(0).getId());
        assertEquals("2", products.get(1).getId());
    }

    @Test
    public void testGetFixedDiscountTotal() {
        Sale sale = new Sale();
        sale.setDiscountCodes(Arrays.asList("DISC1", "DISC2"));

        Discount discount1 = new Discount();
        discount1.setDiscount(10.0f);
        discount1.setDiscountUnit(DiscountUnitEnum.FIXED);

        Discount discount2 = new Discount();
        discount2.setDiscount(5.0f);
        discount2.setDiscountUnit(DiscountUnitEnum.FIXED);

        when(discountDatabase.retrieveDiscount("DISC1")).thenReturn(discount1);
        when(discountDatabase.retrieveDiscount("DISC2")).thenReturn(discount2);

        float fixedDiscountTotal = salesService.getFixedDiscountTotal(sale);

        assertEquals(15.0f, fixedDiscountTotal);
    }

    @Test
    public void testGetPercentDiscountTotal() {
        Sale sale = new Sale();
        sale.setDiscountCodes(Arrays.asList("DISC1", "DISC2"));

        Discount discount1 = new Discount();
        discount1.setDiscount(0.1f);
        discount1.setDiscountUnit(DiscountUnitEnum.PERCENT);

        Discount discount2 = new Discount();
        discount2.setDiscount(0.2f);
        discount2.setDiscountUnit(DiscountUnitEnum.PERCENT);

        when(discountDatabase.retrieveDiscount("DISC1")).thenReturn(discount1);
        when(discountDatabase.retrieveDiscount("DISC2")).thenReturn(discount2);

        float percentDiscountTotal = salesService.getPercentDiscountTotal(sale);

        assertEquals(0.3f, percentDiscountTotal);
    }

    @Test
    public void testGetAppliedDiscounts() {
        Sale sale = new Sale();
        sale.setDiscountCodes(Arrays.asList("DISC1", "DISC2"));

        Discount discount1 = new Discount();
        discount1.setDiscount(10.0f);
        discount1.setDiscountUnit(DiscountUnitEnum.FIXED);

        Discount discount2 = new Discount();
        discount2.setDiscount(0.1f);
        discount2.setDiscountUnit(DiscountUnitEnum.PERCENT);

        when(discountDatabase.retrieveDiscount("DISC1")).thenReturn(discount1);
        when(discountDatabase.retrieveDiscount("DISC2")).thenReturn(discount2);

        List<Discount> appliedDiscounts = salesService.getAppliedDiscounts(sale);

        assertEquals(2, appliedDiscounts.size());
        assertEquals(10.0f, appliedDiscounts.get(0).getDiscount());
        assertEquals(0.1f, appliedDiscounts.get(1).getDiscount());
    }

    @Test
    public void testBuildSaleItemsAndDiscounts() {
        Sale sale = new Sale();
        SaleItem item1 = new SaleItem();
        item1.setId("1");
        item1.setQuantity(2);
        sale.setSaleItems(Collections.singletonList(item1));

        Product product1 = new Product();
        product1.setId("1");
        product1.setPrice(100.0f);

        when(productDatabase.retrieve("1")).thenReturn(product1);

        List<SoldItem> soldItems = salesService.buildSaleItemsAndDiscounts(sale, 10.0f, 0.1f);

        assertEquals(1, soldItems.size());
        assertEquals("1", soldItems.get(0).getId());
        assertEquals(2, soldItems.get(0).getQuantity());
        assertEquals(100.0f, soldItems.get(0).getUnitPrice());
        assertEquals(30.0f, soldItems.get(0).getAppliedDiscount());
        assertEquals(170.0f, soldItems.get(0).getTotalBeforeTax());
    }

    @Test
    public void testGetSaleSummary() {
        SoldItem item1 = new SoldItem();
        item1.setTotalBeforeTax(100.0f);
        SoldItem item2 = new SoldItem();
        item2.setTotalBeforeTax(200.0f);

        List<SoldItem> soldItems = Arrays.asList(item1, item2);

        SaleSummary saleSummary = salesService.getSaleSummary(soldItems);

        assertEquals(300.0f, saleSummary.getTotalBeforeTaxes());
        assertEquals(0.13f, saleSummary.getTaxRate());
        assertEquals(39.0f, saleSummary.getTaxes());
        assertEquals(339.0f, saleSummary.getTotalAfterTaxes());
    }

    @Test
    public void testGetSaleReceipt() {
        Sale sale = new Sale();
        SaleItem item1 = new SaleItem();
        item1.setId("1");
        item1.setQuantity(2);
        sale.setSaleItems(Collections.singletonList(item1));
        sale.setDiscountCodes(Arrays.asList("DISC1", "DISC2"));

        Product product1 = new Product();
        product1.setId("1");
        product1.setPrice(100.0f);

        Discount discount1 = new Discount();
        discount1.setName("DISC1");
        discount1.setDiscount(10.0f);
        discount1.setDiscountUnit(DiscountUnitEnum.FIXED);

        Discount discount2 = new Discount();
        discount2.setName("DISC2");
        discount2.setDiscount(0.1f);
        discount2.setDiscountUnit(DiscountUnitEnum.PERCENT);

        when(productDatabase.retrieve("1")).thenReturn(product1);
        when(discountDatabase.retrieveDiscount("DISC1")).thenReturn(discount1);
        when(discountDatabase.retrieveDiscount("DISC2")).thenReturn(discount2);

        SaleReceipt saleReceipt = salesService.getSaleReceipt(sale);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        try {
            System.out.println(mapper.writeValueAsString(saleReceipt));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(2, saleReceipt.getDiscountCodes().size());
        assertEquals(1, saleReceipt.getSoldItems().size());
        assertEquals(192.1f, saleReceipt.getSaleSummary().getTotalAfterTaxes());
    }
}