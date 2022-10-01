package com.jocelinlaroch08.inventorymanagement.repository;

import com.jocelinlaroch08.inventorymanagement.model.CustomerOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderLineRepository extends JpaRepository<CustomerOrderLine, Integer> {
}
