package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String code;

    private String designation;

    private BigDecimal unitPriceHt;

    private BigDecimal unitPriceTtc;

    private BigDecimal vat;

    private String photo;

    private CategoryDto categoryDto;

    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
        }

        return ArticleDto.builder()
                .id(article.getId())
                .code(article.getCode())
                .designation(article.getDesignation())
                .unitPriceHt(article.getUnitPriceHt())
                .unitPriceTtc(article.getUnitPriceTtc())
                .vat(article.getVat())
                .photo(article.getPhoto())
                .categoryDto(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCode(articleDto.getCode());
        article.setDesignation(articleDto.getDesignation());
        article.setUnitPriceHt(articleDto.getUnitPriceHt());
        article.setUnitPriceTtc(articleDto.getUnitPriceTtc());
        article.setVat(articleDto.getVat());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategoryDto()));

        return article;
    }

}
