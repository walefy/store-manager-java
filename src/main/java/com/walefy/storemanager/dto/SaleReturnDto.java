package com.walefy.storemanager.dto;

import com.walefy.storemanager.entity.Sale;
import com.walefy.storemanager.entity.SaleProduct;
import java.time.LocalDateTime;
import java.util.List;

public record SaleReturnDto(Long id, LocalDateTime date, List<SaleProduct> products) {
  public static SaleReturnDto fromEntity(Sale sale) {
    return new SaleReturnDto(sale.getId(), sale.getDate(), sale.getSaleProducts());
  }
}
