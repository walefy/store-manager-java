package com.walefy.storemanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_products")
public class SaleProduct {
  @EmbeddedId
  private SaleProductId id = new SaleProductId();

  @ManyToOne
  @MapsId("saleId")
  @JoinColumn(name = "sale_id")
  private Sale sale;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(nullable = false)
  private Integer quantity;

  public SaleProduct(Product product, Sale sale, Integer quantity) {
    this.product = product;
    this.sale = sale;
    this.quantity = quantity;
  }

  public SaleProductId getId() {
    return id;
  }

  public void setId(SaleProductId id) {
    this.id = id;
  }

  public Sale getSale() {
    return sale;
  }

  public void setSale(Sale sale) {
    this.sale = sale;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
