package com.walefy.storemanager.dto;

import com.walefy.storemanager.entity.Sale;
import java.time.LocalDateTime;

public record SaleCreateDto(LocalDateTime dateTime) {
  public Sale toEntity() {
    return new Sale(dateTime);
  }
}
