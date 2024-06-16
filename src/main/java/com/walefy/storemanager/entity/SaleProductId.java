package com.walefy.storemanager.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SaleProductId implements Serializable {
  private Long saleId;
  private Long productId;
}
