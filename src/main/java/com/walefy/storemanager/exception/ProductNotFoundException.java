package com.walefy.storemanager.exception;

public class ProductNotFoundException extends NotFoundException {
  public ProductNotFoundException() {
    super("Product not found!");
  }
}
