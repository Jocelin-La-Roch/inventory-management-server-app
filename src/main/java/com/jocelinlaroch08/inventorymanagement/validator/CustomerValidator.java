package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public static List<String> validate(CustomerDto customerDto) {
        List<String> errors = new ArrayList<>();

        if (customerDto == null) {
            errors.add("Fill firstname");
            errors.add("Fill lastname");
            errors.add("Fill email");
            errors.add("Fill phone");
        }

        if (!StringUtils.hasLength(customerDto.getFirstname())) {
            errors.add("Fill firstname");
        }
        if (!StringUtils.hasLength(customerDto.getLastname())) {
            errors.add("Fill lastname");
        }
        if (!StringUtils.hasLength(customerDto.getEmail())) {
            errors.add("Fill email");
        }
        if (!StringUtils.hasLength(customerDto.getPhone())) {
            errors.add("Fill phone");
        }

        return errors;
    }
}
