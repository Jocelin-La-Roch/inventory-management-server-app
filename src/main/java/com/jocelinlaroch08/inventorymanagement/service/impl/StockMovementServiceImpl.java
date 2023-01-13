package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.StockMovementDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.StockMovement;
import com.jocelinlaroch08.inventorymanagement.repository.StockMovementRepository;
import com.jocelinlaroch08.inventorymanagement.service.StockMovementService;
import com.jocelinlaroch08.inventorymanagement.validator.StockMovementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockMovementServiceImpl implements StockMovementService {

    private StockMovementRepository stockMovementRepository;

    @Autowired
    public StockMovementServiceImpl(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    @Override
    public StockMovementDto save(StockMovementDto stockMovementDto) {
        List<String> errors = StockMovementValidator.validate(stockMovementDto);
        if(!errors.isEmpty()) {
            log.error("Stock movement is not valid {}", stockMovementDto);
            throw new InvalidEntityException("Stock movement is not valid", ErrorCode.STOCK_MOVEMENT_NOT_VALID, errors);
        }
        StockMovement savedStockMovement = stockMovementRepository.save(StockMovementDto.toEntity(stockMovementDto));
        return StockMovementDto.fromEntity(savedStockMovement);
    }

    @Override
    public StockMovementDto findById(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }

        Optional<StockMovement> stockMovement = stockMovementRepository.findById(id);

        StockMovementDto stockMovementDto = StockMovementDto.fromEntity(stockMovement.get());

        return Optional.of(stockMovementDto).orElseThrow(() -> new EntityNotFoundException("No stockMovement found", ErrorCode.ARTICLE_NOT_FOUND));
    }

    /* @Override
    public StockMovementDto findByCode(String code) {
        if (code == null) {
            log.error("Code is null");
            return null;
        }
        Optional<StockMovement> stockMovement = stockMovementRepository.findByCode(code);

        StockMovementDto stockMovementDto = StockMovementDto.fromEntity(stockMovement.get());

        return Optional.of(stockMovementDto).orElseThrow(() -> new EntityNotFoundException("No stockMovement found", ErrorCode.ARTICLE_NOT_FOUND));
    }*/

    @Override
    public List<StockMovementDto> findAll() {
        return stockMovementRepository.findAll().stream().map(StockMovementDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return;
        }
        stockMovementRepository.deleteById(id);
    }
}
