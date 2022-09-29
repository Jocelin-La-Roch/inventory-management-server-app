package com.jocelinlaroch08.inventorymanagement.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer_order_lines")
public class CustomerOrderLine extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder order;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "quantity")
    private BigDecimal quantity;

}
