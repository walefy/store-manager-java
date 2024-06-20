package com.walefy.storemanager.service;

import com.walefy.storemanager.dto.SaleCreateDto;
import com.walefy.storemanager.dto.SaleReturnDto;
import com.walefy.storemanager.entity.Product;
import com.walefy.storemanager.entity.Sale;
import com.walefy.storemanager.entity.SaleProduct;
import com.walefy.storemanager.exception.ProductNotFoundException;
import com.walefy.storemanager.repository.SaleProductRepository;
import com.walefy.storemanager.repository.SaleRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
  private final SaleRepository saleRepository;
  private final SaleProductRepository saleProductRepository;
  private final ProductService productService;

  @Autowired
  public SaleService(SaleRepository saleRepository, SaleProductRepository saleProductRepository,
    ProductService productService) {
    this.saleRepository = saleRepository;
    this.saleProductRepository = saleProductRepository;
    this.productService = productService;
  }

  @Transactional
  public Sale create(List<SaleCreateDto> saleCreate) throws ProductNotFoundException {
    Sale sale = this.saleRepository.save(new Sale());

    for (SaleCreateDto saleCreateDto : saleCreate) {
      Product product = this.productService.findById(saleCreateDto.productId());
      SaleProduct saleProduct = new SaleProduct(product, sale, saleCreateDto.quantity());
      this.saleProductRepository.save(saleProduct);
    }

    return sale;
  }
}
