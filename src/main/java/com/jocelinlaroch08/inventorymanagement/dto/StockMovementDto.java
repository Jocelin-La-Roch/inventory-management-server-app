package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.StockMovement;
import com.jocelinlaroch08.inventorymanagement.model.StockMovementType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class StockMovementDto {

    private Integer id;

    private Instant date;

    private BigDecimal quantity;

    private ArticleDto articleDto;

    private StockMovementType type;

    private Integer companyId;

    public StockMovementDto fromEntity(StockMovement stockMovement) {
        if (stockMovement == null) {
            return  null;
        }

        return StockMovementDto.builder()
                .id(stockMovement.getId())
                .date(stockMovement.getDate())
                .quantity(stockMovement.getQuantity())
                .companyId(stockMovement.getCompanyId())
                .type(stockMovement.getType())
                .articleDto(ArticleDto.fromEntity(stockMovement.getArticle()))
                .build();
    }

    public StockMovement toEntity(StockMovementDto stockMovementDto) {
        if (stockMovementDto == null) {
            return null;
        }

        StockMovement stockMovement = new StockMovement();
        stockMovement.setId(stockMovementDto.getId());
        stockMovement.setDate(stockMovementDto.getDate());
        stockMovement.setQuantity(stockMovementDto.getQuantity());
        stockMovement.setCompanyId(stockMovementDto.getCompanyId());
        stockMovement.setType(stockMovementDto.getType());
        stockMovement.setArticle(ArticleDto.toEntity(stockMovementDto.getArticleDto()));

        return stockMovement;
    }

}
