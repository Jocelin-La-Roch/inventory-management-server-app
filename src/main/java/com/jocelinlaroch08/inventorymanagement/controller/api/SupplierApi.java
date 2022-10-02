package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.SupplierDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SupplierApi {

    @PostMapping(value = Utils.APP_ROOT + "/suppliers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierDto save(@RequestBody SupplierDto supplierDto);

    @GetMapping(value = Utils.APP_ROOT+"/suppliers/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierDto findById(@PathVariable("supplierId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/suppliers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupplierDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/suppliers/delete/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("supplierId") Integer id);

}
