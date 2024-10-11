package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.example.demo.repository.entity.Discount;
import com.example.demo.model.DiscountUnitEnum;

import org.springframework.stereotype.Component;

@Component
public class DiscountDatabase {

    /*
     * TODO: Load up discounts from a static file within our fat-jar, or just
     * hard-code for now
     */

    private final Map<String, Discount> database = new ConcurrentHashMap<>();

    public DiscountDatabase() {
        database.put("BACK-TO-SCHOOL", new Discount("BACK-TO-SCHOOL", DiscountUnitEnum.PERCENT, 0.10f));
        database.put("EMPLOYEE-DISCOUNT", new Discount("EMPLOYEE-DISCOUNT", DiscountUnitEnum.FIXED, 10.00f));
    }

    public Discount retrieveDiscount(String key) {
        if (key != null) {
            return database.get(key);
        } else {
            return null;
        }
    }

    public List<Discount> retrieveAllDiscounts() {
        return new ArrayList<>(database.values());
    }

}
