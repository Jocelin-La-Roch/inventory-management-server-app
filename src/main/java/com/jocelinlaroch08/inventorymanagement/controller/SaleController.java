package com.jocelinlaroch08.inventorymanagement.controller;

import com.jocelinlaroch08.inventorymanagement.controller.api.SaleApi;
import com.jocelinlaroch08.inventorymanagement.dto.SaleDto;
import com.jocelinlaroch08.inventorymanagement.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleController implements SaleApi {

    private SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @Override
    public SaleDto save(SaleDto saleDto) {
        return saleService.save(saleDto);
    }

    @Override
    public SaleDto findById(Integer id) {
        return saleService.findById(id);
    }

    @Override
    public SaleDto findByCode(String code) {
        return saleService.findByCode(code);
    }

    @Override
    public List<SaleDto> findAll() {
        return saleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        saleService.delete(id);
    }
}
