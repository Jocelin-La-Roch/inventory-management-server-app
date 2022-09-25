package com.jocelinlaroch08.inventorymanagement.validator;


import com.jocelinlaroch08.inventorymanagement.dto.SupplierDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SupplierValidator {

    public static List<String> validate(SupplierDto supplierDto) {
        List<String> errors = new ArrayList<>();

        if (supplierDto == null) {
            errors.add("Fill firstname");
            errors.add("Fill lastname");
            errors.add("Fill email");
            errors.add("Fill phone");
        }

        if (!StringUtils.hasLength(supplierDto.getFirstname())) {
            errors.add("Fill firstname");
        }
        if (!StringUtils.hasLength(supplierDto.getLastname())) {
            errors.add("Fill lastname");
        }
        if (!StringUtils.hasLength(supplierDto.getEmail())) {
            errors.add("Fill email");
        }
        if (!StringUtils.hasLength(supplierDto.getPhone())) {
            errors.add("Fill phone");
        }

        return errors;
    }
}
