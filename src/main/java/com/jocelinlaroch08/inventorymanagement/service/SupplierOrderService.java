package com.jocelinlaroch08.inventorymanagement.service;

import com.jocelinlaroch08.inventorymanagement.dto.SupplierOrderDto;

import java.util.List;

public interface SupplierOrderService {

    SupplierOrderDto save(SupplierOrderDto supplierOrderDto);

    SupplierOrderDto findById(Integer integer);

    SupplierOrderDto findByCode(String code);

    List<SupplierOrderDto> findAll();

    void delete(Integer integer);

}
