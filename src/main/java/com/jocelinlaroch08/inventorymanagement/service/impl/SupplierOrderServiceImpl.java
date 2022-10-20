package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.SupplierOrderDto;
import com.jocelinlaroch08.inventorymanagement.dto.SupplierOrderLineDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.Article;
import com.jocelinlaroch08.inventorymanagement.model.Supplier;
import com.jocelinlaroch08.inventorymanagement.model.SupplierOrder;
import com.jocelinlaroch08.inventorymanagement.model.SupplierOrderLine;
import com.jocelinlaroch08.inventorymanagement.repository.*;
import com.jocelinlaroch08.inventorymanagement.service.SupplierOrderService;
import com.jocelinlaroch08.inventorymanagement.validator.SupplierOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierOrderServiceImpl implements SupplierOrderService {

    private SupplierOrderRepository supplierOrderRepository;
    private SupplierRepository supplierRepository;
    private ArticleRepository articleRepository;
    private SupplierOrderLineRepository supplierOrderLineRepository;

    public SupplierOrderServiceImpl(SupplierOrderRepository supplierOrderRepository,
                                    SupplierRepository supplierRepository, ArticleRepository articleRepository, SupplierOrderLineRepository supplierOrderLineRepository) {
        this.supplierOrderRepository = supplierOrderRepository;
        this.supplierRepository = supplierRepository;
        this.articleRepository = articleRepository;
        this.supplierOrderLineRepository = supplierOrderLineRepository;
    }

    @Override
    public SupplierOrderDto save(SupplierOrderDto supplierOrderDto) {
        List<String> errors = SupplierOrderValidator.validate(supplierOrderDto);
        if (!errors.isEmpty()) {
            log.error("Order is not valid {}", supplierOrderDto);
            throw new InvalidEntityException("Order is not valid", ErrorCode.SUPPLIER_ORDER_NOT_VALID, errors);
        }

        Optional<Supplier> supplier = supplierRepository.findById(supplierOrderDto.getSupplierDto().getId());

        if (supplier.isEmpty()) {
            log.warn("Supplier not found");
            throw new EntityNotFoundException("", ErrorCode.SUPPLIER_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (supplierOrderDto.getLineDtoList() != null) {
            supplierOrderDto.getLineDtoList().forEach(supplierOrderLineDto -> {
                if (supplierOrderLineDto.getArticleDto() != null) {
                    Optional<Article> article = articleRepository.findById(supplierOrderLineDto.getArticleDto().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("Article with id : " + supplierOrderLineDto.getArticleDto().getId() + " not found");
                    }
                } else {
                    articleErrors.add("Article can't be null");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("Articles not found");
            throw new InvalidEntityException("Some articles not found", ErrorCode.ARTICLE_NOT_FOUND, articleErrors);
        }

        SupplierOrder savedSupplierOrder = supplierOrderRepository.save(SupplierOrderDto.toEntity(supplierOrderDto));

        // Because on can have no line
        if (supplierOrderDto.getLineDtoList() != null) {
            supplierOrderDto.getLineDtoList().forEach(supplierOrderLineDto -> {
                SupplierOrderLine supplierOrderLine = SupplierOrderLineDto.toEntity(supplierOrderLineDto);
                supplierOrderLine.setOrder(savedSupplierOrder);
                supplierOrderLineRepository.save(supplierOrderLine);
            });
        }

        return SupplierOrderDto.fromEntity(savedSupplierOrder);
    }

    @Override
    public SupplierOrderDto findById(Integer integer) {
        if (integer == null) {
            log.error("ID is null");
            return null;
        }
        return supplierOrderRepository.findById(integer).map(SupplierOrderDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No order found", ErrorCode.SUPPLIER_ORDER_NOT_FOUND));

    }

    @Override
    public SupplierOrderDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("ID is null");
            return null;
        }

        return supplierOrderRepository.findByCode(code).map(SupplierOrderDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No order found", ErrorCode.SUPPLIER_ORDER_NOT_FOUND));

    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return supplierOrderRepository.findAll().stream().map(SupplierOrderDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer integer) {
        if (integer == null) {
            log.error("ID is null");
            return;
        }
        supplierOrderRepository.deleteById(integer);
    }
}
