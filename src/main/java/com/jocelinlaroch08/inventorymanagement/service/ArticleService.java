package com.jocelinlaroch08.inventorymanagement.service;

import com.jocelinlaroch08.inventorymanagement.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCode(String code);

    List<ArticleDto> findAll();

    void delete(Integer id);

}
