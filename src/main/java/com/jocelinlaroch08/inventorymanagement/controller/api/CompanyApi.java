package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.CompanyDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CompanyApi {

    @PostMapping(value = Utils.APP_ROOT + "/companies/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CompanyDto save(@RequestBody CompanyDto companyDto);

    @GetMapping(value = Utils.APP_ROOT+"/companies/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CompanyDto findById(@PathVariable("companyId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/companies/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CompanyDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/companies/delete/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("companyId") Integer id);

}
