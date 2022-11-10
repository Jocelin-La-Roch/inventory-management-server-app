package com.jocelinlaroch08.inventorymanagement.service;

import com.jocelinlaroch08.inventorymanagement.dto.StockMovementDto;

import java.util.List;

public interface StockMovementService {

    StockMovementDto save(StockMovementDto stockMovementDto);

    StockMovementDto findById(Integer id);

    StockMovementDto findByCode(String code);

    List<StockMovementDto> findAll();

    void delete(Integer id);

}
