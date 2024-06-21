package com.walefy.storemanager.exception;

public class SaleNotFoundException extends NotFoundException {
  public SaleNotFoundException() {
    super("Sale not found!");
  }
}
