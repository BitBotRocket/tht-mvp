package io.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.repository.DiscountDatabase;
import io.swagger.repository.ProductDatabase;
import io.swagger.model.Sale;
import io.swagger.model.SaleProducts;
import io.swagger.model.SaleReceipt;
import io.swagger.model.SaleReceiptDiscounts;
import io.swagger.model.SaleReceiptProducts;
import io.swagger.model.SaleReceiptSummary;
import io.swagger.model.SaleReceiptDiscounts.DiscountUnitEnum;

import java.util.List;
import java.math.BigDecimal;
import io.swagger.model.Product;
import java.util.ArrayList;
import io.swagger.repository.entity.Discount;

@Service
public class SalesService {

    private final ProductDatabase productDatabase;

    private final DiscountDatabase discounts;

    @Autowired
    public SalesService(ProductDatabase productDatabase, DiscountDatabase discounts) {
        this.productDatabase = productDatabase;
        this.discounts = discounts;
    }

    private List<Product> findMatchingProductsFromRequest(List<SaleProducts> saleProductList) {
        List<Product> products = new ArrayList<>();
        for (SaleProducts item : saleProductList) {
            final Product p = productDatabase.retrieve(item.getId());
            if (p != null) {
                products.add(p);
            }
        }
        return products;
    }

    private float getFixedDiscountTotal(Sale request) {

        float fixedDiscountTotal = 0.0f;
        for (String discountCode : request.getDiscounts()) {
            final Discount discount = discounts.retrieveDiscount(discountCode);
            if (discount != null && discount.getDiscountUnit().equals(DiscountUnitEnum.FIXED)) {
                fixedDiscountTotal += discount.getDiscount();
            }
        }
        return fixedDiscountTotal;
    }

    private float getPercentDiscountTotal(Sale request) {

        float percentDiscountTotal = 0.0f;
        for (String discountCode : request.getDiscounts()) {
            final Discount discount = discounts.retrieveDiscount(discountCode);
            if (discount != null && discount.getDiscountUnit().equals(DiscountUnitEnum.PERCENT)) {
                percentDiscountTotal += discount.getDiscount();
            }
        }
        return percentDiscountTotal;
    }

    private List<SaleReceiptDiscounts> getAppliedDiscounts(Sale request) {
        List<SaleReceiptDiscounts> appliedDiscounts = new ArrayList<>();
        for (String discountCode : request.getDiscounts()) {
            SaleReceiptDiscounts appliedDiscount = null;
            final Discount discount = discounts.retrieveDiscount(discountCode);
            if (discount != null) {
                appliedDiscount = new SaleReceiptDiscounts();
                appliedDiscount.setCode(discountCode);
                appliedDiscount.setDiscount(discount.getDiscount());
                appliedDiscount.setDiscountUnit(discount.getDiscountUnit());
                appliedDiscounts.add(appliedDiscount);
            }
        }
        return appliedDiscounts;
    }

    private List<SaleReceiptProducts> buildSaleItemsWithAppliedDiscounts(List<Product> products, Sale request,
            float uniformDiscount, float percentDiscountTotal) {

        List<SaleReceiptProducts> saleItems = new ArrayList<>();

        for (SaleProducts item : request.getProducts()) {

            final Product p = productDatabase.retrieve(item.getId());

            if (p != null) {

                SaleReceiptProducts itemReceipt = new SaleReceiptProducts();
                float price = p.getPrice();
                float quantity = item.getQuantity();
                float discount = 0.0f;
                float totalBeforeTax = price * quantity;

                if (uniformDiscount > 0.0f) {
                    discount += uniformDiscount;
                }

                if (percentDiscountTotal > 0.0f) {
                    discount += price * quantity * percentDiscountTotal;
                }

                totalBeforeTax -= discount;

                itemReceipt.setAppliedDiscount(discount);
                itemReceipt.setUnitPrice(price);
                itemReceipt.setId(p.getId());
                itemReceipt.setQuantity(new BigDecimal(quantity));
                itemReceipt.setTotalBeforeTax(totalBeforeTax);

                saleItems.add(itemReceipt);
            }

        }
        return saleItems;
    }

    private SaleReceiptSummary buildSalesSummary(List<SaleReceiptProducts> saleItems) {
        float totalBeforeTax = 0.0f;
        for (SaleReceiptProducts item : saleItems) {
            totalBeforeTax += item.getTotalBeforeTax();
        }

        SaleReceiptSummary salesSummary = new SaleReceiptSummary();

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

    public SaleReceipt processSalesRequest(Sale request) {

        final SaleReceipt salesResponse = new SaleReceipt();

        /*
         * Cross-Reference the product items in the request with the product database
         */

        List<Product> products = findMatchingProductsFromRequest(request.getProducts());

        /*
         * Determine total of all "fixed" discounts and apply uniformly to all products
         */

        float fixedDiscountTotal = getFixedDiscountTotal(request);
        float percentDiscountTotal = getPercentDiscountTotal(request);
        float uniformDiscount = 0.0f;

        salesResponse.setDiscounts(getAppliedDiscounts(request));

        if (products.size() > 0) {
            /*
             * TODO: What happens when the applied uniform discount > than the price of the
             * product?
             */
            uniformDiscount = fixedDiscountTotal / products.size();
        }

        final List<SaleReceiptProducts> saleItems = buildSaleItemsWithAppliedDiscounts(products, request,
                uniformDiscount,
                percentDiscountTotal);

        salesResponse.setProducts(saleItems);

        salesResponse.setSummary(buildSalesSummary(saleItems));

        return salesResponse;

    }

}
