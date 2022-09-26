package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.SaleLine;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class SaleLineDto {

    private Integer id;

    private SaleDto saleDto;

    private BigDecimal quantity;


    private ArticleDto articleDto;

    public SaleLineDto fromEntity(SaleLine saleLine) {
        if (saleLine == null) {
            return null;
        }

        return SaleLineDto.builder()
                .id(saleDto.getId())
                .saleDto(SaleDto.fromEntity(saleLine.getSale()))
                .quantity(saleLine.getQuantity())
                .articleDto(ArticleDto.fromEntity(saleLine.getArticle()))
                .build();
    }

    public SaleLine toEntity(SaleLineDto saleLineDto) {
        if (saleLineDto == null) {
            return null;
        }

        SaleLine saleLine = new SaleLine();

        saleLine.setId(saleLineDto.getId());
        saleLine.setQuantity(saleLineDto.getQuantity());
        saleLine.setSale(SaleDto.toEntity(saleLineDto.getSaleDto()));
        saleLine.setArticle(ArticleDto.toEntity(saleLineDto.getArticleDto()));

        return saleLine;
    }

}
