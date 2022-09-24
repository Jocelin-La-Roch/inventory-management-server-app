package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.Sale;
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

    private BigDecimal unitPrice;

    public SaleLineDto fromEntity(SaleLine saleLine) {
        if (saleLine == null) {
            return null;
        }

        return SaleLineDto.builder()
                .id(saleDto.getId())
                .saleDto(this.saleDto.fromEntity(saleLine.getSale()))
                .quantity(saleLine.getQuantity())
                .unitPrice(saleLine.getUnitPrice())
                .build();
    }

    public SaleLine toEntity(SaleLineDto saleLineDto) {
        if (saleLineDto == null) {
            return null;
        }

        SaleLine saleLine = new SaleLine();

        saleLine.setId(saleLineDto.getId());
        saleLine.setQuantity(saleLineDto.getQuantity());
        saleLine.setUnitPrice(saleLineDto.getUnitPrice());
        saleLine.setSale(this.saleDto.toEntity(saleLineDto.getSaleDto()));

        return saleLine;
    }

}
