package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.CustomerOrderLine;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CustomerOrderLineDto {

    private Integer id;

    private ArticleDto articleDto;

    private CustomerOrderDto orderDto;

    private BigDecimal quantity;

    public static CustomerOrderLineDto fromEntity(CustomerOrderLine customerOrderLine) {
        if (customerOrderLine == null) {
            return null;
        }

        return CustomerOrderLineDto.builder()
                .id(customerOrderLine.getId())
                .articleDto(ArticleDto.fromEntity(customerOrderLine.getArticle()))
                .orderDto(CustomerOrderDto.fromEntity(customerOrderLine.getOrder()))
                .quantity(customerOrderLine.getQuantity())
                .build();
    }

    public static CustomerOrderLine toEntity(CustomerOrderLineDto customerOrderLineDto) {
        if (customerOrderLineDto == null) {
            return null;
        }

        CustomerOrderLine customerOrderLine = new CustomerOrderLine();
        customerOrderLine.setId(customerOrderLineDto.getId());
        customerOrderLine.setArticle(ArticleDto.toEntity(customerOrderLineDto.getArticleDto()));
        customerOrderLine.setOrder(CustomerOrderDto.toEntity(customerOrderLineDto.getOrderDto()));
        customerOrderLine.setQuantity(customerOrderLineDto.getQuantity());

        return  customerOrderLine;
    }

}
