package com.jocelinlaroch08.inventorymanagement.repository;

import com.jocelinlaroch08.inventorymanagement.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockMovementRepository extends JpaRepository<StockMovement, Integer> {

    // Optional<StockMovement> findByCode(String code);

}
