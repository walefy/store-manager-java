package com.walefy.storemanager.dto;

import com.walefy.storemanager.entity.Product;

public record ProductReturnDto(Long id, String name) {
  public static ProductReturnDto fromEntity(Product product) {
    return new ProductReturnDto(product.getId(), product.getName());
  }
}
