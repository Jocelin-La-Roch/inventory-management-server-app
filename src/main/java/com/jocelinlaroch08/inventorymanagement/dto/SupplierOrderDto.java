package com.jocelinlaroch08.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jocelinlaroch08.inventorymanagement.model.SupplierOrder;
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

    private Integer companyId;

    private SupplierDto supplierDto;

    private List<SupplierOrderLineDto> lineDtoList;

    public static SupplierOrderDto fromEntity(SupplierOrder supplierOrder) {
        if (supplierOrder == null) {
            return null;
        }

        return SupplierOrderDto.builder()
                .id(supplierOrder.getId())
                .code(supplierOrder.getCode())
                .date(supplierOrder.getDate())
                .companyId(supplierOrder.getCompanyId())
                .supplierDto(SupplierDto.fromEntity(supplierOrder.getSupplier()))
                .build();
    }

    public static SupplierOrder toEntity(SupplierOrderDto supplierOrderDto) {
        if (supplierOrderDto == null) {
            return null;
        }

        SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setId(supplierOrderDto.getId());
        supplierOrder.setCode(supplierOrderDto.getCode());
        supplierOrder.setDate(supplierOrderDto.getDate());
        supplierOrder.setCompanyId(supplierOrderDto.getCompanyId());
        supplierOrder.setSupplier(SupplierDto.toEntity(supplierOrderDto.getSupplierDto()));

        return supplierOrder;
    }

}
