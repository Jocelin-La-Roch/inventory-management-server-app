package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.ArticleDto;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.repository.ArticleRepository;
import com.jocelinlaroch08.inventorymanagement.service.ArticleService;
import com.jocelinlaroch08.inventorymanagement.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);

        if(!errors.isEmpty()) {
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("Article is not valid", ErrorCode.ARTICLE_NOT_VALID, errors);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        return null;
    }

    @Override
    public ArticleDto findByCode(String code) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
