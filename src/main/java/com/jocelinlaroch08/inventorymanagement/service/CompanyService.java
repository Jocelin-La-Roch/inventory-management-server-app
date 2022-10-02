package com.jocelinlaroch08.inventorymanagement.service;

import com.jocelinlaroch08.inventorymanagement.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    CompanyDto save(CompanyDto companyDto);

    CompanyDto findById(Integer id);

    List<CompanyDto> findAll();

    void delete(Integer id);
}
