package com.jocelinlaroch08.inventorymanagement.service;

import com.jocelinlaroch08.inventorymanagement.dto.SaleDto;

import java.util.List;

public interface SaleService {

    SaleDto save(SaleDto saleDto);

    SaleDto findById(Integer integer);

    SaleDto findByCode(String code);

    List<SaleDto> findAll();

}
