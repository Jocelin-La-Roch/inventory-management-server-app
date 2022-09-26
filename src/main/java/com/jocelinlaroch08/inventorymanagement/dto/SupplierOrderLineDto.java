package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.SupplierOrderLine;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class SupplierOrderLineDto {

    private Integer id;

    private ArticleDto articleDto;

    private SupplierOrderDto orderDto;

    private BigDecimal quantity;

    public  SupplierOrderLineDto fromEntity(SupplierOrderLine supplierOrderLine) {
        if (supplierOrderLine == null) {
            return null;
        }

        return SupplierOrderLineDto.builder()
                .id(supplierOrderLine.getId())
                .articleDto(ArticleDto.fromEntity(supplierOrderLine.getArticle()))
                .orderDto(SupplierOrderDto.fromEntity(supplierOrderLine.getOrder()))
                .quantity(supplierOrderLine.getQuantity())
                .build();
    }

    public SupplierOrderLine toEntity(SupplierOrderLineDto supplierOrderLineDto) {
        if (supplierOrderLineDto == null) {
            return null;
        }

        SupplierOrderLine supplierOrderLine = new SupplierOrderLine();
        supplierOrderLine.setId(supplierOrderLineDto.getId());
        supplierOrderLine.setArticle(ArticleDto.toEntity(supplierOrderLineDto.getArticleDto()));
        supplierOrderLine.setOrder(SupplierOrderDto.toEntity(supplierOrderLineDto.getOrderDto()));
        supplierOrderLine.setQuantity(supplierOrderLineDto.getQuantity());

        return supplierOrderLine;
    }

}
