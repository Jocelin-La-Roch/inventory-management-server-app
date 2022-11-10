package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.SaleDto;
import com.jocelinlaroch08.inventorymanagement.dto.SaleLineDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.Article;
import com.jocelinlaroch08.inventorymanagement.model.Sale;
import com.jocelinlaroch08.inventorymanagement.model.SaleLine;
import com.jocelinlaroch08.inventorymanagement.repository.ArticleRepository;
import com.jocelinlaroch08.inventorymanagement.repository.SaleLIneRepository;
import com.jocelinlaroch08.inventorymanagement.repository.SaleRepository;
import com.jocelinlaroch08.inventorymanagement.service.SaleService;
import com.jocelinlaroch08.inventorymanagement.validator.SaleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SaleServiceImpl implements SaleService {

    private SaleLIneRepository saleLineRepository;
    private ArticleRepository articleRepository;
    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleLIneRepository saleLineRepository, ArticleRepository articleRepository, SaleRepository saleRepository) {
        this.saleLineRepository = saleLineRepository;
        this.articleRepository = articleRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public SaleDto save(SaleDto saleDto) {
        List<String> errors = SaleValidator.validate(saleDto);
        if (!errors.isEmpty()) {
            log.error("Order is not valid {}", saleDto);
            throw new InvalidEntityException("Order is not valid", ErrorCode.SALE_NOT_VALID, errors);
        }
        List<String> articleErrors = new ArrayList<>();
        if (saleDto.getLineDtoList() != null) {
            saleDto.getLineDtoList().forEach(customerOrderLineDto -> {
                if (customerOrderLineDto.getArticleDto() != null) {
                    Optional<Article> article = articleRepository.findById(customerOrderLineDto.getArticleDto().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("Article with id : " + customerOrderLineDto.getArticleDto().getId() + " not found");
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
        Sale savedSale = saleRepository.save(SaleDto.toEntity(saleDto));
        if (saleDto.getLineDtoList() != null) {
            saleDto.getLineDtoList().forEach(saleLineDto -> {
                SaleLine saleLine = SaleLineDto.toEntity(saleLineDto);
                saleLine.setSale(savedSale);
                saleLineRepository.save(saleLine);
            });
        }
        return  SaleDto.fromEntity(savedSale);
    }

    @Override
    public SaleDto findById(Integer integer) {
        if (integer == null) {
            log.error("ID is null");
            return null;
        }
        return saleRepository.findById(integer).map(SaleDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No sale found", ErrorCode.SALE_NOT_FOUND));
    }

    @Override
    public SaleDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("ID is null");
            return null;
        }
        return saleRepository.findByCode(code).map(SaleDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No sale found", ErrorCode.SALE_NOT_FOUND));
    }

    @Override
    public List<SaleDto> findAll() {
        return saleRepository.findAll().stream().map(SaleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer integer) {
        if (integer == null) {
            log.error("ID is null");
            return;
        }
        saleRepository.deleteById(integer);
    }
}
