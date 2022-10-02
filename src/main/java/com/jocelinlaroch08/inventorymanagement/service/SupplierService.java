package com.jocelinlaroch08.inventorymanagement.service;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerDto;
import com.jocelinlaroch08.inventorymanagement.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto save(SupplierDto supplierDto);

    SupplierDto findById(Integer id);

    List<SupplierDto> findAll();

    void delete(Integer id);

}
