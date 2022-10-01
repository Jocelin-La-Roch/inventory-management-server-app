package com.jocelinlaroch08.inventorymanagement.repository;

import com.jocelinlaroch08.inventorymanagement.model.SupplierOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine, Integer> {
}
