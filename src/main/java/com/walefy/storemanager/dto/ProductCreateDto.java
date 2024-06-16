package com.walefy.storemanager.dto;

import com.walefy.storemanager.entity.Product;

public record ProductCreateDto(String name) {
  public Product toEntity() {
    return new Product(name);
  }
}
