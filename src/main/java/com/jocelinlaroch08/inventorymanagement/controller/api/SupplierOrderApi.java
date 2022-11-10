package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.SupplierOrderDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SupplierOrderApi {

    @PostMapping(value = Utils.APP_ROOT + "/supplier-orders/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierOrderDto save(@RequestBody SupplierOrderDto supplierOrderDto);

    @GetMapping(value = Utils.APP_ROOT+"/supplier-orders/{supplierOrderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierOrderDto findById(@PathVariable("supplierOrderId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/supplier-orders/{supplierOrderCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierOrderDto findByCode(@PathVariable("supplierOrderCode") String code);

    @GetMapping(value = Utils.APP_ROOT+"/supplier-orders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupplierOrderDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/supplier-orders/delete/{supplierOrderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("supplierOrderId") Integer id);

}
