package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerOrderDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerOrderApi {

    @PostMapping(value = Utils.APP_ROOT + "/customer-orders/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerOrderDto save(@RequestBody CustomerOrderDto customerOrderDto);

    @GetMapping(value = Utils.APP_ROOT+"/customer-orders/{customerOrderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerOrderDto findById(@PathVariable("customerOrderId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/customer-orders/{customerOrderCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerOrderDto findByCode(@PathVariable("customerOrderCode") String code);

    @GetMapping(value = Utils.APP_ROOT+"/customer-orders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomerOrderDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/customer-orders/delete/{customerOrderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("customerOrderId") Integer id);

}
