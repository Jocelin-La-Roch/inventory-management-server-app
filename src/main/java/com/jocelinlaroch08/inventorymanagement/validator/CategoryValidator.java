package com.jocelinlaroch08.inventorymanagement.validator;


import com.jocelinlaroch08.inventorymanagement.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        if ( categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
            errors.add("Fill the code field");
        }

        return errors;
    }

}
