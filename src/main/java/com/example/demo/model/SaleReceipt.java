package com.example.demo.model;

import java.util.List;
import com.example.demo.model.SoldItem;
import com.example.demo.model.SaleSummary;
import com.example.demo.repository.entity.Discount;

public class SaleReceipt {

    private final List<Discount> discountCodes;
    private final List<SoldItem> soldItems;
    private final SaleSummary saleSummary;

    public SaleReceipt(List<Discount> discountCodes, List<SoldItem> soldItems, SaleSummary saleSummary) {
        this.discountCodes = discountCodes;
        this.soldItems = soldItems;
        this.saleSummary = saleSummary;
    }

    public List<Discount> getDiscountCodes() {
        return discountCodes;
    }

    public List<SoldItem> getSoldItems() {
        return soldItems;
    }

    public SaleSummary getSaleSummary() {
        return saleSummary;
    }

}
