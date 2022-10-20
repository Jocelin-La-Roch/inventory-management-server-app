package com.jocelinlaroch08.inventorymanagement.repository;

import com.jocelinlaroch08.inventorymanagement.model.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Integer> {

    Optional<SupplierOrder> findByCode(String code);

}
