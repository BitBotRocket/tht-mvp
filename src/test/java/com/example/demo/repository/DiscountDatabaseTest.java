package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;
import com.example.demo.model.DiscountUnitEnum;
import com.example.demo.repository.entity.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DiscountDatabaseTest {

    private DiscountDatabase discountDatabase;

    @BeforeEach
    public void setUp() {
        discountDatabase = new DiscountDatabase();
    }

    @Test
    public void testRetrieveDiscount_ValidKey() {
        Discount discount = discountDatabase.retrieveDiscount("BACK-TO-SCHOOL");
        assertEquals("BACK-TO-SCHOOL", discount.getName());
        assertEquals(DiscountUnitEnum.PERCENT, discount.getDiscountUnit());
        assertEquals(0.10f, discount.getDiscount());
    }

    @Test
    public void testRetrieveDiscount_InvalidKey() {
        Discount discount = discountDatabase.retrieveDiscount("INVALID-CODE");
        assertNull(discount);
    }

    @Test
    public void testRetrieveDiscount_NullKey() {
        Discount discount = discountDatabase.retrieveDiscount(null);
        assertNull(discount);
    }

    @Test
    public void testRetrieveAllDiscounts() {
        List<Discount> discounts = discountDatabase.retrieveAllDiscounts();
        assertEquals(2, discounts.size());
        
        Discount discount1 = discounts.get(0);
        Discount discount2 = discounts.get(1);
        
        if (discount1.getName().equals("BACK-TO-SCHOOL")) {
            assertEquals(DiscountUnitEnum.PERCENT, discount1.getDiscountUnit());
            assertEquals(0.10f, discount1.getDiscount());
            assertEquals("EMPLOYEE-DISCOUNT", discount2.getName());
            assertEquals(DiscountUnitEnum.FIXED, discount2.getDiscountUnit());
            assertEquals(10.00f, discount2.getDiscount());
        } else {
            assertEquals("EMPLOYEE-DISCOUNT", discount1.getName());
            assertEquals(DiscountUnitEnum.FIXED, discount1.getDiscountUnit());
            assertEquals(10.00f, discount1.getDiscount());
            assertEquals("BACK-TO-SCHOOL", discount2.getName());
            assertEquals(DiscountUnitEnum.PERCENT, discount2.getDiscountUnit());
            assertEquals(0.10f, discount2.getDiscount());
        }
    }
}