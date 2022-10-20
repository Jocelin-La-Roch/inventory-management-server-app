package com.jocelinlaroch08.inventorymanagement.dto;

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

    private List<CustomerOrderLineDto> lineDtoList;

    public static CustomerOrderDto fromEntity(CustomerOrder customerOrder) {
        if(customerOrder == null) {
            return  null;
        }

        return CustomerOrderDto.builder()
                .id(customerOrder.getId())
                .code(customerOrder.getCode())
                .date(customerOrder.getDate())
                .customerDto(CustomerDto.fromEntity(customerOrder.getCustomer()))
                .build();
    }

    public static CustomerOrder toEntity(CustomerOrderDto customerOrderDto) {
        if (customerOrderDto == null) {
            return null;
        }

        CustomerOrder customerOrder = new CustomerOrder();

        customerOrder.setId(customerOrderDto.getId());
        customerOrder.setDate(customerOrderDto.getDate());
        customerOrder.setCode(customerOrderDto.getCode());
        customerOrder.setCustomer(CustomerDto.toEntity(customerOrderDto.getCustomerDto()));

        return customerOrder;
    }

}
