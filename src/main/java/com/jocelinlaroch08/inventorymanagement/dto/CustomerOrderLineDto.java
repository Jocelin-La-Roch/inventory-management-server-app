package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.CustomerOrderLine;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerOrderLineDto {

    private Integer id;

    private ArticleDto articleDto;

    private CustomerOrderDto orderDto;

    public CustomerOrderLineDto fromEntity(CustomerOrderLine customerOrderLine) {
        if (customerOrderLine == null) {
            return null;
        }

        return CustomerOrderLineDto.builder()
                .id(customerOrderLine.getId())
                .articleDto(this.articleDto.fromEntity(customerOrderLine.getArticle()))
                .orderDto(this.orderDto.fromEntity(customerOrderLine.getOrder()))
                .build();
    }

    public CustomerOrderLine toEntity(CustomerOrderLineDto customerOrderLineDto) {
        if (customerOrderLineDto == null) {
            return null;
        }

        CustomerOrderLine customerOrderLine = new CustomerOrderLine();
        customerOrderLine.setId(customerOrderLineDto.getId());
        customerOrderLine.setArticle(this.articleDto.toEntity(customerOrderLineDto.getArticleDto()));
        customerOrderLine.setOrder(this.orderDto.toEntity(customerOrderLineDto.getOrderDto()));
        return  customerOrderLine;
    }

}
