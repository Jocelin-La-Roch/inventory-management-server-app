package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.Sale;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class SaleDto {

    private Integer id;

    private String code;

    private Instant date;

    private String comment;

    public SaleDto fromEntity(Sale sale) {
        if (sale == null) {
            return null;
        }
        return SaleDto.builder()
                .id(sale.getId())
                .code(sale.getCode())
                .date(sale.getDate())
                .comment(sale.getComment())
                .build();
    }

    public Sale toEntity(SaleDto saleDto) {
        if(saleDto == null) {
            return null;
        }
        Sale sale = new Sale();
        sale.setId(saleDto.getId());
        sale.setDate(saleDto.getDate());
        sale.setComment(saleDto.getComment());
        return sale;
    }

}
