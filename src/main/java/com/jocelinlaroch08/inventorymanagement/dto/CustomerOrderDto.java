package com.jocelinlaroch08.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jocelinlaroch08.inventorymanagement.model.Customer;
import com.jocelinlaroch08.inventorymanagement.model.CustomerOrder;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CustomerOrderDto {

    private Integer id;

    private String code;

    private Instant date;

    private CustomerDto customerDto;

    @JsonIgnore
    private List<CustomerOrderLineDto> lineDtoList;

    public CustomerOrderDto fromEntity(CustomerOrder customerOrder) {
        if(customerOrder == null) {
            return  null;
        }

        return CustomerOrderDto.builder()
                .id(customerOrder.getId())
                .code(customerOrder.getCode())
                .date(customerOrder.getDate())
                .customerDto(this.customerDto.fromEntity(customerOrder.getCustomer()))
                .build();
    }

    public CustomerOrder toEntity(CustomerOrderDto customerOrderDto) {
        if (customerOrderDto == null) {
            return null;
        }

        CustomerOrder customerOrder = new CustomerOrder();

        customerOrder.setId(customerOrderDto.getId());
        customerOrder.setDate(customerOrderDto.getDate());
        customerOrder.setCode(customerOrderDto.getCode());
        customerOrder.setCustomer(this.customerDto.toEntity(customerOrderDto.getCustomerDto()));

        return customerOrder;
    }

}
