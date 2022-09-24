package com.jocelinlaroch08.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jocelinlaroch08.inventorymanagement.model.Supplier;
import com.jocelinlaroch08.inventorymanagement.model.SupplierOrder;
import com.jocelinlaroch08.inventorymanagement.model.SupplierOrderLine;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class SupplierOrderDto {

    private Integer id;

    private String code;

    private Instant date;

    private SupplierDto supplierDto;

    @JsonIgnore
    private List<SupplierOrderLineDto> lineDtoList;

    public SupplierOrderDto fromEntity(SupplierOrder supplierOrder) {
        if (supplierOrder == null) {
            return null;
        }

        return SupplierOrderDto.builder()
                .id(supplierOrder.getId())
                .code(supplierOrder.getCode())
                .date(supplierOrder.getDate())
                .supplierDto(this.supplierDto.fromEntity(supplierOrder.getSupplier()))
                .build();
    }

    public SupplierOrder toEntity(SupplierOrderDto supplierOrderDto) {
        if (supplierOrderDto == null) {
            return null;
        }

        SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setId(supplierOrderDto.getId());
        supplierOrder.setCode(supplierOrderDto.getCode());
        supplierOrder.setDate(supplierOrderDto.getDate());
        supplierOrder.setSupplier(this.supplierDto.toEntity(supplierOrderDto.getSupplierDto()));

        return supplierOrder;
    }

}
