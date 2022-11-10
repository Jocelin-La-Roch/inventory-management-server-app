package com.jocelinlaroch08.inventorymanagement.controller;

import com.jocelinlaroch08.inventorymanagement.controller.api.SupplierOrderApi;
import com.jocelinlaroch08.inventorymanagement.dto.SupplierOrderDto;
import com.jocelinlaroch08.inventorymanagement.service.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierOrderController implements SupplierOrderApi {

    private SupplierOrderService supplierOrderService;

    @Autowired
    public SupplierOrderController(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @Override
    public SupplierOrderDto save(SupplierOrderDto supplierOrderDto) {
        return supplierOrderService.save(supplierOrderDto);
    }

    @Override
    public SupplierOrderDto findById(Integer id) {
        return supplierOrderService.findById(id);
    }

    @Override
    public SupplierOrderDto findByCode(String code) {
        return supplierOrderService.findByCode(code);
    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return supplierOrderService.findAll();
    }

    @Override
    public void delete(Integer id) {
        supplierOrderService.delete(id);
    }
}
