package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.Address;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class AddressDto {

    private String address1;

    private String address2;

    private String city;

    private String zipCode;

    private String country;

    public AddressDto fromEntity(Address address) {
        if (address == null) {
            return  null;
        }
        return  AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }

    public  Address toEntity(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }

        return Address.builder()
                .address1(addressDto.getAddress1())
                .address2(addressDto.getAddress2())
                .zipCode(addressDto.getZipCode())
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .build();

    }

}
