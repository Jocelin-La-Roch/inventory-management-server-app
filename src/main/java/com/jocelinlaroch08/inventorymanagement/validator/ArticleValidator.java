package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if(articleDto == null) {
            errors.add("Fill code");
            errors.add("Fill designation");
            errors.add("Fill unit price ht");
            errors.add("Fill vat");
            errors.add("Fill unit price ttc");
            errors.add("Select a category");

            return errors;
        }

        if (!StringUtils.hasLength(articleDto.getCode())) {
            errors.add("Fill code");
        }
        if (!StringUtils.hasLength(articleDto.getDesignation())) {
            errors.add("Fill designation");
        }
        if (articleDto.getUnitPriceHt() == null) {
            errors.add("Fill unit price ht");
        }
        if (articleDto.getVat() == null) {
            errors.add("Fill vat");
        }
        if (articleDto.getUnitPriceTtc() == null) {
            errors.add("Fill unit price ttc");
        }

        if (articleDto.getCategoryDto() == null) {
            errors.add("Select a category");
        }

        return errors;
    }

}
