package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.Category;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private String code;

    private String designation;

    private BigDecimal unitPriceHt;

    private BigDecimal unitPriceTtc;

    private BigDecimal vat;

    private String photo;

    private Category category;

}
