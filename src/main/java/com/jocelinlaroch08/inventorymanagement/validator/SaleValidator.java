package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.SaleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SaleValidator {

    public static List<String> validate(SaleDto saleDto) {
        List<String> errors = new ArrayList<>();

        if (saleDto == null) {
            errors.add("Fill code");
            errors.add("Fill comment");
            errors.add("Fill date");
        }

        if (!StringUtils.hasLength(saleDto.getCode())){
            errors.add("Fill code");
        }
        if (!StringUtils.hasLength(saleDto.getComment())){
            errors.add("Fill comment");
        }
        if(saleDto.getDate() == null) {
            errors.add("Fill date");
        }

        return errors;
    }
}
