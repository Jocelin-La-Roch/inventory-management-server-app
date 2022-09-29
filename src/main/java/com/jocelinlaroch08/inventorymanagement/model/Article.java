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
@Table(name = "articles")
public class Article extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "unit_price_ht")
    private BigDecimal unitPriceHt;

    @Column(name = "unit_price_ttc")
    private BigDecimal unitPriceTtc;

    @Column(name = "vat")
    private BigDecimal vat;

    @Column(name = "photo")
    private String photo;

    @Column(name = "company_id")
    private Integer companyId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
