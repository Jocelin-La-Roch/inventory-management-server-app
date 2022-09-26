package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.SupplierOrderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderValidator {

    public static List<String> validate (SupplierOrderDto supplierOrderDto) {
        List<String> errors = new ArrayList<>();

        if (supplierOrderDto == null) {
            errors.add("Fill code");
            errors.add("Fill date");
            errors.add("Select supplier");

            return errors;
        }

        if (!StringUtils.hasLength(supplierOrderDto.getCode())) {
            errors.add("Fill code");
        }
        if (supplierOrderDto.getDate() == null) {
            errors.add("Fill date");
        }
        if (supplierOrderDto.getSupplierDto() == null) {
            errors.add("Select customer");
        }

        return errors;
    }
}
