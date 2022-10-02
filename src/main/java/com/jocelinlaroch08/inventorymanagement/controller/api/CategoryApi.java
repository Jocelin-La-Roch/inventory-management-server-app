package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.CategoryDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryApi {

    @PostMapping(value = Utils.APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = Utils.APP_ROOT+"/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("categoryId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/categories/{categoryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable("categoryCode") String code);

    @GetMapping(value = Utils.APP_ROOT+"/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/categories/delete/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("categoryId") Integer id);

}
