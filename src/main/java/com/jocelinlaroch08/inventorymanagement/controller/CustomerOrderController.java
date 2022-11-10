package com.jocelinlaroch08.inventorymanagement.controller;

import com.jocelinlaroch08.inventorymanagement.controller.api.CustomerOrderApi;
import com.jocelinlaroch08.inventorymanagement.dto.CustomerOrderDto;
import com.jocelinlaroch08.inventorymanagement.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerOrderController implements CustomerOrderApi {

    private CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @Override
    public CustomerOrderDto save(CustomerOrderDto customerOrderDto) {
        return customerOrderService.save(customerOrderDto);
    }

    @Override
    public CustomerOrderDto findById(Integer id) {
        return customerOrderService.findById(id);
    }

    @Override
    public CustomerOrderDto findByCode(String code) {
        return customerOrderService.findByCode(code);
    }

    @Override
    public List<CustomerOrderDto> findAll() {
        return customerOrderService.findAll();
    }

    @Override
    public void delete(Integer id) {
        customerOrderService.delete(id);
    }
}
