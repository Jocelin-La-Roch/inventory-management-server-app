package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();

        if(userDto == null) {
            errors.add("Fill the lastName");
            errors.add("Fill the firstName");
            errors.add("Fill the email");
            errors.add("Fill the password");
            errors.add("Fill the address");

            return errors;
        }

        if (!StringUtils.hasLength(userDto.getLastname())) {
            errors.add("Fill the lastName");
        }
        if (!StringUtils.hasLength(userDto.getFirstname())) {
            errors.add("Fill the firstName");
        }
        if (!StringUtils.hasLength(userDto.getEmail())) {
            errors.add("Fill the email");
        }
        if (!StringUtils.hasLength(userDto.getPassword())) {
            errors.add("Fill the password");
        }
        if (userDto.getBirthDate() == null) {
            errors.add("Fill date of birth");
        }
        if (userDto.getAddressDto() == null) {
            errors.add("Fill the address");
        } else {
            if (!StringUtils.hasLength(userDto.getAddressDto().getAddress1())) {
                errors.add("Fill the address 1");
            }
            if (!StringUtils.hasLength(userDto.getAddressDto().getCountry())) {
                errors.add("Fill the country");
            }
            if (!StringUtils.hasLength(userDto.getAddressDto().getCity())) {
                errors.add("Fill the city");
            }
            if (!StringUtils.hasLength(userDto.getAddressDto().getZipCode())) {
                errors.add("Fill the zip code");
            }
        }

        return errors;
    }



}
