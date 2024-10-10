package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DiscountUnitEnum;
import com.example.demo.model.Product;
import com.example.demo.model.Sale;
import com.example.demo.model.SaleItem;
import com.example.demo.model.SaleReceipt;
import com.example.demo.model.SaleSummary;
import com.example.demo.repository.DiscountDatabase;
import com.example.demo.repository.ProductDatabase;
import com.example.demo.repository.entity.Discount;
import com.example.demo.model.SoldItem;
import java.util.List;
import java.util.ArrayList;

@Service
public class SalesService {

    private final ProductDatabase productDatabase;

    private final DiscountDatabase discountDatabase;

    @Autowired
    public SalesService(ProductDatabase productDatabase, DiscountDatabase discountDatabase) {
        this.productDatabase = productDatabase;
        this.discountDatabase = discountDatabase;
    }

    private List<Product> findMatchingProductsFromRequest(Sale sale) {
        List<Product> soldProducts = new ArrayList<>();
        for (SaleItem item : sale.getSaleItems()) {
            final Product p = productDatabase.retrieve(item.getId());
            if (p != null) {
                soldProducts.add(p);
            }
        }
        return soldProducts;

    }

    private float getFixedDiscountTotal(Sale sale) {

        float fixedDiscountTotal = 0.0f;
        for (String discountCode : sale.getDiscountCodes()) {
            final Discount discount = discountDatabase.retrieveDiscount(discountCode);
            if (discount != null && discount.getDiscountUnit().equals(DiscountUnitEnum.FIXED)) {
                fixedDiscountTotal += discount.getDiscount();
            }
        }
        return fixedDiscountTotal;
    }

    private float getPercentDiscountTotal(Sale sale) {

        float percentDiscountTotal = 0.0f;
        for (String discountCode : sale.getDiscountCodes()) {
            final Discount discount = discountDatabase.retrieveDiscount(discountCode);
            if (discount != null && discount.getDiscountUnit().equals(DiscountUnitEnum.PERCENT)) {
                percentDiscountTotal += discount.getDiscount();
            }
        }
        return percentDiscountTotal;
    }

    private List<Discount> getAppliedDiscounts(Sale sale) {
        List<Discount> appliedDiscounts = new ArrayList<>();
        for (String discountCode : sale.getDiscountCodes()) {

            final Discount discount = discountDatabase.retrieveDiscount(discountCode);
            if (discount != null) {
                appliedDiscounts.add(discount);
            }
        }
        return appliedDiscounts;
    }

    private List<SoldItem> buildSaleItemsAndDiscounts(Sale sale, float uniformDiscount, float percentDiscountTotal) {

        List<SoldItem> soldItems = new ArrayList<>();

        for (SaleItem item : sale.getSaleItems()) {

            final Product p = productDatabase.retrieve(item.getId());

            if (p != null) {

                SaleItem saleItem = new SaleItem();
                float price = p.getPrice();
                int quantity = item.getQuantity();
                float discount = 0.0f;
                float totalBeforeTax = price * quantity;

                if (uniformDiscount > 0.0f) {
                    discount += uniformDiscount;
                }

                if (percentDiscountTotal > 0.0f) {
                    discount += price * quantity * percentDiscountTotal;
                }

                totalBeforeTax -= discount;

                SoldItem soldItem = new SoldItem();

                soldItem.setAppliedDiscount(discount);
                soldItem.setUnitPrice(price);
                soldItem.setId(p.getId());
                soldItem.setQuantity(quantity);
                soldItem.setTotalBeforeTax(totalBeforeTax);

                soldItems.add(soldItem);
            }

        }
        return soldItems;
    }

    private SaleSummary getSaleSummary(List<SoldItem> soldItems) {
        float totalBeforeTax = 0.0f;
        for (SoldItem item : soldItems) {
            totalBeforeTax += item.getTotalBeforeTax();
        }

        SaleSummary salesSummary = new SaleSummary();

        // TODO: Make applied tax percentage configurable
        salesSummary.setTotalBeforeTaxes(totalBeforeTax);
        salesSummary.setTaxRate(0.13f);
        salesSummary.setTaxes(totalBeforeTax * 0.13f);
        salesSummary.setTotalAfterTaxes(totalBeforeTax * 1.13f);

        return salesSummary;

    }

    /*
     * TODO: lots of good junit opportunities here
     */

    public SaleReceipt getSaleReceipt(Sale sale) {

        /*
         * Cross-Reference the product items in the request with the product database
         */

        List<Product> products = findMatchingProductsFromRequest(sale);

        /*
         * Determine total of all "fixed" discounts and apply uniformly to all products
         */

        float fixedDiscountTotal = getFixedDiscountTotal(sale);
        float percentDiscountTotal = getPercentDiscountTotal(sale);
        float uniformDiscount = 0.0f;

        if (products.size() > 0) {
            /*
             * TODO: What happens when the applied uniform discount > than the price of the
             * product?
             */
            uniformDiscount = fixedDiscountTotal / products.size();
        }

        List<SoldItem> soldItems = buildSaleItemsAndDiscounts(sale, uniformDiscount, percentDiscountTotal);

        return new SaleReceipt(
                getAppliedDiscounts(sale),
                soldItems,
                getSaleSummary(soldItems));

    }

}
