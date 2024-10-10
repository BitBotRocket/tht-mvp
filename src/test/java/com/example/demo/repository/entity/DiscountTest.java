package com.example.demo.repository.entity;

import com.example.demo.model.DiscountUnitEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountTest {

    @Test
    public void testDiscountConstructorAndGetters() {
        String name = "Holiday Sale";
        DiscountUnitEnum discountUnit = DiscountUnitEnum.PERCENT;
        float discountValue = 20.0f;

        Discount discount = new Discount(name, discountUnit, discountValue);

        assertEquals(name, discount.getName());
        assertEquals(discountUnit, discount.getDiscountUnit());
        assertEquals(discountValue, discount.getDiscount());
    }
}