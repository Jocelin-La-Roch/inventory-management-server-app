package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.StockMovementDto;

import java.util.ArrayList;
import java.util.List;

public class StockMovementValidator {

    public static List<String> validate(StockMovementDto stockMovementDto) {
        List<String> errors = new ArrayList<>();

        if (stockMovementDto == null) {
            errors.add("Fill date");
            errors.add("Fill quantity");
            errors.add("Select article");
            errors.add("Select type");

           return errors;
        }

        if (stockMovementDto.getDate() == null) {
            errors.add("Fill date");
        }

        if (stockMovementDto.getArticleDto() == null) {
            errors.add("Select article");
        }
        if (stockMovementDto.getType() == null) {
            errors.add("Select type");
        }
        if (stockMovementDto.getQuantity() == null) {
            errors.add("Fill quantity");
        }

        return errors;
    }
}
