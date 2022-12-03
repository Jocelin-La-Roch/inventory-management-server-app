package com.jocelinlaroch08.inventorymanagement.controller;

import com.jocelinlaroch08.inventorymanagement.controller.api.StockMovementApi;
import com.jocelinlaroch08.inventorymanagement.dto.StockMovementDto;
import com.jocelinlaroch08.inventorymanagement.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockMovementController implements StockMovementApi {

    private StockMovementService stockMovementService;

    // Constructor Injection
    @Autowired
    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @Override
    public StockMovementDto save(StockMovementDto stockMovementDto) {
        return stockMovementService.save(stockMovementDto);
    }

    @Override
    public StockMovementDto findById(Integer id) {
        return stockMovementService.findById(id);
    }

    /*@Override
    public StockMovementDto findByCode(String code) {
        return stockMovementService.findByCode(code);
    }*/

    @Override
    public List<StockMovementDto> findAll() {
        return stockMovementService.findAll();
    }

    @Override
    public void delete(Integer id) {
        stockMovementService.delete(id);
    }

}
