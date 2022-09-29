package com.jocelinlaroch08.inventorymanagement.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stock_movements")
public class StockMovement extends AbstractEntity{

    @Column(name = "date")
    private Instant date;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "type")
    private StockMovementType type;

}
