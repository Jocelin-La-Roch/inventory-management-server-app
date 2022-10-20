package com.jocelinlaroch08.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jocelinlaroch08.inventorymanagement.model.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CustomerDto {

    private Integer id;

    private String firstname;

    private String lastname;

    private AddressDto addressDto;

    private String photo;

    private String email;

    private String phone;

    private Integer companyId;

    @JsonIgnore
    private List<CustomerOrderDto> orderDtoList;

    public static CustomerDto fromEntity(Customer customer) {
        if (customer == null) {
            return null;
        }

        return CustomerDto.builder()
                .id(customer.getId())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .addressDto(AddressDto.fromEntity(customer.getAddress()))
                .photo(customer.getPhoto())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .companyId(customer.getCompanyId())
                .build();
    }

    public static Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) {
            return  null;
        }

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setAddress(AddressDto.toEntity(customerDto.getAddressDto()));
        customer.setPhoto(customerDto.getPhoto());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setCompanyId(customerDto.getCompanyId());

        return customer;
    }

}
