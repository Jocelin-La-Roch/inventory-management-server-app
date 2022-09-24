package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.SupplierOrderLine;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class SupplierOrderLineDto {

    private Integer id;

    private ArticleDto articleDto;

    private SupplierOrderDto orderDto;

    public  SupplierOrderLineDto fromEntity(SupplierOrderLine supplierOrderLine) {
        if (supplierOrderLine == null) {
            return null;
        }

        return SupplierOrderLineDto.builder()
                .id(supplierOrderLine.getId())
                .articleDto(this.articleDto.fromEntity(supplierOrderLine.getArticle()))
                .orderDto(this.orderDto.fromEntity(supplierOrderLine.getOrder()))
                .build();
    }

    public SupplierOrderLine toEntity(SupplierOrderLineDto supplierOrderLineDto) {
        if (supplierOrderLineDto == null) {
            return null;
        }

        SupplierOrderLine supplierOrderLine = new SupplierOrderLine();
        supplierOrderLine.setId(supplierOrderLineDto.getId());
        supplierOrderLine.setArticle(this.articleDto.toEntity(supplierOrderLineDto.getArticleDto()));
        supplierOrderLine.setOrder(this.orderDto.toEntity(supplierOrderLineDto.getOrderDto()));

        return supplierOrderLine;
    }

}
