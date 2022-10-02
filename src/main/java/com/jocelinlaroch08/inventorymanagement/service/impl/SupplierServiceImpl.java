package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.SupplierDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.Supplier;
import com.jocelinlaroch08.inventorymanagement.repository.SupplierRepository;
import com.jocelinlaroch08.inventorymanagement.service.SupplierService;
import com.jocelinlaroch08.inventorymanagement.validator.SupplierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        List<String> errors = SupplierValidator.validate(supplierDto);

        if(!errors.isEmpty()) {
            log.error("Supplier is not valid {}", supplierDto);
            throw new InvalidEntityException("Supplier is not valid", ErrorCode.SUPPLIER_NOT_VALID, errors);
        }

        Supplier savedSupplier = supplierRepository.save(SupplierDto.toEntity(supplierDto));

        return SupplierDto.fromEntity(savedSupplier);
    }

    @Override
    public SupplierDto findById(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }

        Optional<Supplier> supplier = supplierRepository.findById(id);

        SupplierDto supplierDto = SupplierDto.fromEntity(supplier.get());

        return Optional.of(supplierDto).orElseThrow(() -> new EntityNotFoundException("No supplier found", ErrorCode.SUPPLIER_NOT_FOUND));
    }

    @Override
    public List<SupplierDto> findAll() {
        return supplierRepository.findAll().stream().map(SupplierDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return;
        }
        supplierRepository.deleteById(id);
    }
}
