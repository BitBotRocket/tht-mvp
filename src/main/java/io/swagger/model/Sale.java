package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.SaleProducts;
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
 * Sale
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-09T18:44:33.080945746Z[GMT]")


public class Sale   {
  @JsonProperty("discounts")
  @Valid
  private List<String> discounts = null;
  @JsonProperty("products")
  @Valid
  private List<SaleProducts> products = null;

  public Sale discounts(List<String> discounts) { 

    this.discounts = discounts;
    return this;
  }

  public Sale addDiscountsItem(String discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<String>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

  /**
   * Get discounts
   * @return discounts
   **/
  
  @Schema(description = "")
  
  public List<String> getDiscounts() {  
    return discounts;
  }



  public void setDiscounts(List<String> discounts) { 
    this.discounts = discounts;
  }

  public Sale products(List<SaleProducts> products) { 

    this.products = products;
    return this;
  }

  public Sale addProductsItem(SaleProducts productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<SaleProducts>();
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
  public List<SaleProducts> getProducts() {  
    return products;
  }



  public void setProducts(List<SaleProducts> products) { 
    this.products = products;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sale sale = (Sale) o;
    return Objects.equals(this.discounts, sale.discounts) &&
        Objects.equals(this.products, sale.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discounts, products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sale {\n");
    
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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
