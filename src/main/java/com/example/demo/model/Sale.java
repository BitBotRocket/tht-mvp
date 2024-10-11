package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private List<String> discountCodes = new ArrayList<>();
    private List<SaleItem> saleItems = new ArrayList<>();

    public Sale() {
    }

    public Sale(List<String> discountCodes, List<SaleItem> saleItems) {
        this.discountCodes = discountCodes;
        this.saleItems = saleItems;
    }

    public List<String> getDiscountCodes() {
        return discountCodes;
    }

    public void setDiscountCodes(List<String> discountCodes) {
        this.discountCodes = discountCodes;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

}
