package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerOrderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderValidator {

    public static List<String> validate(CustomerOrderDto customerOrderDto) {
        List<String> errors = new ArrayList<>();

        if (customerOrderDto == null) {
            errors.add("Fill code");
            errors.add("Fill date");
            errors.add("Select customer");

            return errors;
        }

        if (!StringUtils.hasLength(customerOrderDto.getCode())) {
            errors.add("Fill code");
        }
        if (customerOrderDto.getDate() == null) {
            errors.add("Fill date");
        }
        if (customerOrderDto.getCustomerDto() == null) {
            errors.add("Select customer");
        }

        return errors;
    }
}
