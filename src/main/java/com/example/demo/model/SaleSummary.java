package com.example.demo.model;

public class SaleSummary {

  private float totalBeforeTaxes;
  private float taxRate;
  private float taxes;
  private float totalAfterTaxes;

  public SaleSummary() {
  }

  public SaleSummary(float totalBeforeTaxes, float taxRate, float taxes, float totalAfterTaxes) {
    this.totalBeforeTaxes = totalBeforeTaxes;
    this.taxRate = taxRate;
    this.taxes = taxes;
    this.totalAfterTaxes = totalAfterTaxes;
  }

  public float getTotalBeforeTaxes() {
    return totalBeforeTaxes;
  }

  public void setTotalBeforeTaxes(float totalBeforeTaxes) {
    this.totalBeforeTaxes = totalBeforeTaxes;
  }

  public float getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(float taxRate) {
    this.taxRate = taxRate;
  }

  public float getTaxes() {
    return taxes;
  }

  public void setTaxes(float taxes) {
    this.taxes = taxes;
  }

  public float getTotalAfterTaxes() {
    return totalAfterTaxes;
  }

  public void setTotalAfterTaxes(float totalAfterTaxes) {
    this.totalAfterTaxes = totalAfterTaxes;
  }

}
