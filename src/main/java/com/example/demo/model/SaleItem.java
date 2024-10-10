package com.example.demo.model;

public class SaleItem {
    
    private String id;
    private int quantity;
    
    public SaleItem() {
    }

    public SaleItem(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
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
}
