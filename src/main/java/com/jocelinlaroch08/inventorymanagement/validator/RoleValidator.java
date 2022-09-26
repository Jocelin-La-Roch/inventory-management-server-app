package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.RoleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {

    public static List<String> validate(RoleDto roleDto) {
        List<String> errors = new ArrayList<>();

        if (roleDto == null) {
            errors.add("Fill label");
            errors.add("Select user");

            return errors;
        }

        if(!StringUtils.hasLength(roleDto.getLabel())) {
            errors.add("Fill label");
        }
        if(roleDto.getUserDto() == null) {
            errors.add("Select user");
        }

        return errors;
    }
}
