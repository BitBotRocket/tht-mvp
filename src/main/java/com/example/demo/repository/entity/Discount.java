package com.example.demo.repository.entity;

import com.example.demo.model.DiscountUnitEnum; 

public final class Discount {
    private String name;
    private DiscountUnitEnum discountUnit;
    private float discount;

    public Discount() {
    }

    public Discount(String name, DiscountUnitEnum discountUnit, float discount) {
        this.name = name;
        this.discountUnit = discountUnit;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public DiscountUnitEnum getDiscountUnit() {
        return discountUnit;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscountUnit(DiscountUnitEnum discountUnit) {
        this.discountUnit = discountUnit;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
}
