package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.SupplierOrderLineDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderLineValidator {
    public static List<String> validate(SupplierOrderLineDto supplierOrderLineDto) {
        List<String> errors = new ArrayList<>();

        if(supplierOrderLineDto == null) {
            errors.add("Select order");
            errors.add("Select article");
            errors.add("Fill quantity");

            return errors;
        }

        if (supplierOrderLineDto.getOrderDto() == null) {
            errors.add("Select order");
        }
        if (supplierOrderLineDto.getArticleDto() == null) {
            errors.add("Select article");
        }
        if (supplierOrderLineDto.getQuantity() == null) {
            errors.add("Fill quantity");
        }


        return errors;
    }

}
