package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.SaleLineDto;

import java.util.ArrayList;
import java.util.List;

public class SaleLineValidator {

    public static List<String> validate(SaleLineDto saleLineDto) {
        List<String> errors = new ArrayList<>();

        if (saleLineDto == null) {
            errors.add("Select sale");
            errors.add("Fill quantity");
            errors.add("Fill article");

            return errors;
        }

        if (saleLineDto.getSaleDto() == null) {
            errors.add("Select sale");
        }
        if (saleLineDto.getQuantity() == null) {
            errors.add("Fill quantity");
        }
        if (saleLineDto.getArticleDto() == null) {
            errors.add("Select article");
        }

        return errors;
    }
}
