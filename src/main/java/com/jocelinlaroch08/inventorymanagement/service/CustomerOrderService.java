package com.jocelinlaroch08.inventorymanagement.service;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerOrderDto;

import java.util.List;

public interface CustomerOrderService {

    CustomerOrderDto save(CustomerOrderDto customerOrderDto);

    CustomerOrderDto findById(Integer integer);

    CustomerOrderDto findByCode(String code);

    List<CustomerOrderDto> findAll();

    void delete(Integer integer);

}
