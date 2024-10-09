package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SaleReceiptSummary
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-09T18:44:33.080945746Z[GMT]")


public class SaleReceiptSummary   {
  @JsonProperty("totalBeforeTaxes")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float totalBeforeTaxes = null;

  @JsonProperty("taxRate")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float taxRate = null;

  @JsonProperty("taxes")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float taxes = null;

  @JsonProperty("totalAfterTaxes")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float totalAfterTaxes = null;


  public SaleReceiptSummary totalBeforeTaxes(Float totalBeforeTaxes) { 

    this.totalBeforeTaxes = totalBeforeTaxes;
    return this;
  }

  /**
   * Get totalBeforeTaxes
   * @return totalBeforeTaxes
   **/
  
  @Schema(description = "")
  
  public Float getTotalBeforeTaxes() {  
    return totalBeforeTaxes;
  }



  public void setTotalBeforeTaxes(Float totalBeforeTaxes) { 
    this.totalBeforeTaxes = totalBeforeTaxes;
  }

  public SaleReceiptSummary taxRate(Float taxRate) { 

    this.taxRate = taxRate;
    return this;
  }

  /**
   * Get taxRate
   * @return taxRate
   **/
  
  @Schema(description = "")
  
  public Float getTaxRate() {  
    return taxRate;
  }



  public void setTaxRate(Float taxRate) { 
    this.taxRate = taxRate;
  }

  public SaleReceiptSummary taxes(Float taxes) { 

    this.taxes = taxes;
    return this;
  }

  /**
   * Get taxes
   * @return taxes
   **/
  
  @Schema(description = "")
  
  public Float getTaxes() {  
    return taxes;
  }



  public void setTaxes(Float taxes) { 
    this.taxes = taxes;
  }

  public SaleReceiptSummary totalAfterTaxes(Float totalAfterTaxes) { 

    this.totalAfterTaxes = totalAfterTaxes;
    return this;
  }

  /**
   * Get totalAfterTaxes
   * @return totalAfterTaxes
   **/
  
  @Schema(description = "")
  
  public Float getTotalAfterTaxes() {  
    return totalAfterTaxes;
  }



  public void setTotalAfterTaxes(Float totalAfterTaxes) { 
    this.totalAfterTaxes = totalAfterTaxes;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleReceiptSummary saleReceiptSummary = (SaleReceiptSummary) o;
    return Objects.equals(this.totalBeforeTaxes, saleReceiptSummary.totalBeforeTaxes) &&
        Objects.equals(this.taxRate, saleReceiptSummary.taxRate) &&
        Objects.equals(this.taxes, saleReceiptSummary.taxes) &&
        Objects.equals(this.totalAfterTaxes, saleReceiptSummary.totalAfterTaxes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalBeforeTaxes, taxRate, taxes, totalAfterTaxes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleReceiptSummary {\n");
    
    sb.append("    totalBeforeTaxes: ").append(toIndentedString(totalBeforeTaxes)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
    sb.append("    totalAfterTaxes: ").append(toIndentedString(totalAfterTaxes)).append("\n");
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
