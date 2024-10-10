package com.example.demo.model;

public enum DiscountUnitEnum {
    FIXED("fixed"),
    PERCENT("percent");

    private String value;

    DiscountUnitEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}