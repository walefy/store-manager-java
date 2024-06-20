package com.walefy.storemanager.repository;

import com.walefy.storemanager.entity.SaleProduct;
import com.walefy.storemanager.entity.SaleProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, SaleProductId> {
}
