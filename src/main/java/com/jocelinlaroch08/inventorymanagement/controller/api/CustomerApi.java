package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerApi {

    @PostMapping(value = Utils.APP_ROOT + "/customers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto save(@RequestBody CustomerDto customerDto);

    @GetMapping(value = Utils.APP_ROOT+"/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto findById(@PathVariable("customerId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomerDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/customers/delete/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(Integer id);

}
