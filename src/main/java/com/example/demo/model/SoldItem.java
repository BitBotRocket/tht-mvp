package com.example.demo.model;

public class SoldItem {

    private String id;
    private int quantity;
    private float unitPrice;
    private float appliedDiscount;
    private float totalBeforeTax;

    public SoldItem() {
    }

    public SoldItem(String id, int quantity, float unitPrice, float appliedDiscount, float totalBeforeTax) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.appliedDiscount = appliedDiscount;
        this.totalBeforeTax = totalBeforeTax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getAppliedDiscount() {
        return appliedDiscount;
    }

    public void setAppliedDiscount(float appliedDiscount) {
        this.appliedDiscount = appliedDiscount;
    }

    public float getTotalBeforeTax() {
        return totalBeforeTax;
    }

    public void setTotalBeforeTax(float totalBeforeTax) {
        this.totalBeforeTax = totalBeforeTax;
    }

}
