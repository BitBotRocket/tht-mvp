package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.SaleReceiptDiscounts;
import io.swagger.model.SaleReceiptProducts;
import io.swagger.model.SaleReceiptSummary;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SaleReceipt
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-09T18:44:33.080945746Z[GMT]")


public class SaleReceipt   {
  @JsonProperty("discounts")
  @Valid
  private List<SaleReceiptDiscounts> discounts = null;
  @JsonProperty("products")
  @Valid
  private List<SaleReceiptProducts> products = null;
  @JsonProperty("summary")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private SaleReceiptSummary summary = null;


  public SaleReceipt discounts(List<SaleReceiptDiscounts> discounts) { 

    this.discounts = discounts;
    return this;
  }

  public SaleReceipt addDiscountsItem(SaleReceiptDiscounts discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<SaleReceiptDiscounts>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

  /**
   * Get discounts
   * @return discounts
   **/
  
  @Schema(description = "")
  @Valid
  public List<SaleReceiptDiscounts> getDiscounts() {  
    return discounts;
  }



  public void setDiscounts(List<SaleReceiptDiscounts> discounts) { 
    this.discounts = discounts;
  }

  public SaleReceipt products(List<SaleReceiptProducts> products) { 

    this.products = products;
    return this;
  }

  public SaleReceipt addProductsItem(SaleReceiptProducts productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<SaleReceiptProducts>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
   **/
  
  @Schema(description = "")
  @Valid
  public List<SaleReceiptProducts> getProducts() {  
    return products;
  }



  public void setProducts(List<SaleReceiptProducts> products) { 
    this.products = products;
  }

  public SaleReceipt summary(SaleReceiptSummary summary) { 

    this.summary = summary;
    return this;
  }

  /**
   * Get summary
   * @return summary
   **/
  
  @Schema(description = "")
  
@Valid
  public SaleReceiptSummary getSummary() {  
    return summary;
  }



  public void setSummary(SaleReceiptSummary summary) { 
    this.summary = summary;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleReceipt saleReceipt = (SaleReceipt) o;
    return Objects.equals(this.discounts, saleReceipt.discounts) &&
        Objects.equals(this.products, saleReceipt.products) &&
        Objects.equals(this.summary, saleReceipt.summary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discounts, products, summary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleReceipt {\n");
    
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
