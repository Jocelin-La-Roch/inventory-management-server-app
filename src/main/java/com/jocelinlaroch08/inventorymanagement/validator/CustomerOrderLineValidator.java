package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.CustomerOrderLineDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderLineValidator {

    public static List<String> validate(CustomerOrderLineDto customerOrderLineDto) {
        List<String> errors = new ArrayList<>();

        if(customerOrderLineDto == null) {
            errors.add("Select order");
            errors.add("Select article");
            errors.add("Fill quantity");

            return errors;
        }

        if (customerOrderLineDto.getOrderDto() == null) {
            errors.add("Select order");
        }
        if (customerOrderLineDto.getArticleDto() == null) {
            errors.add("Select article");
        }
        if (customerOrderLineDto.getQuantity() == null) {
            errors.add("Fill quantity");
        }

        return errors;
    }
}
