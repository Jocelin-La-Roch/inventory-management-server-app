package com.jocelinlaroch08.inventorymanagement.repository;

import com.jocelinlaroch08.inventorymanagement.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement, Integer> {
}
