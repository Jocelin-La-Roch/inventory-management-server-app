package com.jocelinlaroch08.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jocelinlaroch08.inventorymanagement.model.Address;
import com.jocelinlaroch08.inventorymanagement.model.Supplier;
import com.jocelinlaroch08.inventorymanagement.model.SupplierOrder;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import java.util.List;

@Builder
@Data
public class SupplierDto {

    private Integer id;

    private String firstname;

    private String lastname;

    private AddressDto addressDto;

    private String photo;

    private String email;

    private String phone;

    @JsonIgnore
    private List<SupplierOrderDto> orderDtoList;

    public SupplierDto fromEntity(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return SupplierDto.builder()
                .id(supplier.getId())
                .firstname(supplier.getFirstname())
                .lastname(supplier.getLastname())
                .photo(supplier.getPhoto())
                .phone(supplier.getPhone())
                .email(supplier.getEmail())
                .addressDto(this.addressDto.fromEntity(supplier.getAddress()))
                .build();
    }

    public Supplier toEntity(SupplierDto supplierDto) {
        if (supplierDto == null) {
            return null;
        }

        Supplier supplier = new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setFirstname(supplierDto.getFirstname());
        supplier.setLastname(supplierDto.getLastname());
        supplier.setPhone(supplierDto.getPhone());
        supplier.setPhoto(supplierDto.getPhoto());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setAddress(this.addressDto.toEntity(supplierDto.getAddressDto()));

        return supplier;
    }

}
