package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.SaleDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SaleApi {
    @PostMapping(value = Utils.APP_ROOT + "/sales/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    SaleDto save(@RequestBody SaleDto saleDto);
    @GetMapping(value = Utils.APP_ROOT+"/sales/{saleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    SaleDto findById(@PathVariable("saleId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/sales/{saleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    SaleDto findByCode(@PathVariable("saleCode") String code);

    @GetMapping(value = Utils.APP_ROOT+"/sales/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SaleDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/sales/delete/{saleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("saleId") Integer id);
}
