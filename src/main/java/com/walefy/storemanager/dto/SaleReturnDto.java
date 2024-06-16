package com.walefy.storemanager.dto;

import com.walefy.storemanager.entity.Product;
import com.walefy.storemanager.entity.Sale;
import java.time.LocalDateTime;
import java.util.List;

public record SaleReturnDto(Long id, LocalDateTime date, List<Product> products) {
  public static SaleReturnDto fromEntity(Sale sale) {
    return new SaleReturnDto(sale.getId(), sale.getDate(), sale.getProducts());
  }
}
