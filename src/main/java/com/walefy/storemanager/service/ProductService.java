package com.walefy.storemanager.service;

import com.walefy.storemanager.dto.ProductCreateDto;
import com.walefy.storemanager.entity.Product;
import com.walefy.storemanager.exception.ProductNotFoundException;
import com.walefy.storemanager.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional
  public Product create(ProductCreateDto productCreate) {
    return this.productRepository.save(productCreate.toEntity());
  }

  public List<Product> findAll() {
    return this.productRepository.findAll();
  }

  public Product findById(Long id) throws ProductNotFoundException {
    return this.productRepository
      .findById(id)
      .orElseThrow(ProductNotFoundException::new);
  }

  public Product update(Long id, String name) throws ProductNotFoundException {
    // TODO: create a dto to update
    Product product = this.findById(id);
    product.setName(name);
    return this.productRepository.save(product);
  }

  public void delete(Long id) throws ProductNotFoundException {
    Product product = this.findById(id);
    this.productRepository.delete(product);
  }
}
