package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SaleReceiptProducts
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-09T18:44:33.080945746Z[GMT]")


public class SaleReceiptProducts   {
  @JsonProperty("id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String id = null;

  @JsonProperty("quantity")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private BigDecimal quantity = null;

  @JsonProperty("unitPrice")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float unitPrice = null;

  @JsonProperty("appliedDiscount")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float appliedDiscount = null;

  @JsonProperty("totalBeforeTax")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float totalBeforeTax = null;


  public SaleReceiptProducts id(String id) { 

    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
  @Schema(example = "100", description = "")
  
  public String getId() {  
    return id;
  }



  public void setId(String id) { 
    this.id = id;
  }

  public SaleReceiptProducts quantity(BigDecimal quantity) { 

    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   **/
  
  @Schema(description = "")
  
@Valid
  public BigDecimal getQuantity() {  
    return quantity;
  }



  public void setQuantity(BigDecimal quantity) { 
    this.quantity = quantity;
  }

  public SaleReceiptProducts unitPrice(Float unitPrice) { 

    this.unitPrice = unitPrice;
    return this;
  }

  /**
   * Get unitPrice
   * @return unitPrice
   **/
  
  @Schema(description = "")
  
  public Float getUnitPrice() {  
    return unitPrice;
  }



  public void setUnitPrice(Float unitPrice) { 
    this.unitPrice = unitPrice;
  }

  public SaleReceiptProducts appliedDiscount(Float appliedDiscount) { 

    this.appliedDiscount = appliedDiscount;
    return this;
  }

  /**
   * Get appliedDiscount
   * @return appliedDiscount
   **/
  
  @Schema(description = "")
  
  public Float getAppliedDiscount() {  
    return appliedDiscount;
  }



  public void setAppliedDiscount(Float appliedDiscount) { 
    this.appliedDiscount = appliedDiscount;
  }

  public SaleReceiptProducts totalBeforeTax(Float totalBeforeTax) { 

    this.totalBeforeTax = totalBeforeTax;
    return this;
  }

  /**
   * Get totalBeforeTax
   * @return totalBeforeTax
   **/
  
  @Schema(description = "")
  
  public Float getTotalBeforeTax() {  
    return totalBeforeTax;
  }



  public void setTotalBeforeTax(Float totalBeforeTax) { 
    this.totalBeforeTax = totalBeforeTax;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleReceiptProducts saleReceiptProducts = (SaleReceiptProducts) o;
    return Objects.equals(this.id, saleReceiptProducts.id) &&
        Objects.equals(this.quantity, saleReceiptProducts.quantity) &&
        Objects.equals(this.unitPrice, saleReceiptProducts.unitPrice) &&
        Objects.equals(this.appliedDiscount, saleReceiptProducts.appliedDiscount) &&
        Objects.equals(this.totalBeforeTax, saleReceiptProducts.totalBeforeTax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, quantity, unitPrice, appliedDiscount, totalBeforeTax);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleReceiptProducts {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    appliedDiscount: ").append(toIndentedString(appliedDiscount)).append("\n");
    sb.append("    totalBeforeTax: ").append(toIndentedString(totalBeforeTax)).append("\n");
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
