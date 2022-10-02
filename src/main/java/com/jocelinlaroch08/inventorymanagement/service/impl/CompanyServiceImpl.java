package com.jocelinlaroch08.inventorymanagement.service.impl;


import com.jocelinlaroch08.inventorymanagement.dto.ArticleDto;
import com.jocelinlaroch08.inventorymanagement.dto.CompanyDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.Article;
import com.jocelinlaroch08.inventorymanagement.model.Company;
import com.jocelinlaroch08.inventorymanagement.repository.CompanyRepository;
import com.jocelinlaroch08.inventorymanagement.service.CompanyService;
import com.jocelinlaroch08.inventorymanagement.validator.ArticleValidator;
import com.jocelinlaroch08.inventorymanagement.validator.CompanyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public  CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        List<String> errors = CompanyValidator.validate(companyDto);

        if(!errors.isEmpty()) {
            log.error("Company is not valid {}", companyDto);
            throw new InvalidEntityException("Company is not valid", ErrorCode.COMPANY_NOT_VALID, errors);
        }

        Company savedCompany = companyRepository.save(CompanyDto.toEntity(companyDto));

        return CompanyDto.fromEntity(savedCompany);
    }

    @Override
    public CompanyDto findById(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }

        Optional<Company> company = companyRepository.findById(id);

        CompanyDto companyDto = CompanyDto.fromEntity(company.get());

        return Optional.of(companyDto).orElseThrow(() -> new EntityNotFoundException("No company found", ErrorCode.COMPANY_NOT_FOUND));
    }

    @Override
    public List<CompanyDto> findAll() {
        return companyRepository.findAll().stream().map(CompanyDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return;
        }
        companyRepository.deleteById(id);
    }
}
