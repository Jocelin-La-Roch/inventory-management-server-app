package com.jocelinlaroch08.inventorymanagement.validator;

import com.jocelinlaroch08.inventorymanagement.dto.CompanyDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompanyValidator {

    public static List<String> validate(CompanyDto companyDto) {
        List<String> errors = new ArrayList<>();

        if(companyDto == null) {
            errors.add("Fill name");
            errors.add("Fill description");
            errors.add("Fill address");
            errors.add("Fill tax code");
            errors.add("Fill email");
            errors.add("Fill phone");

            return errors;
        }

        if (!StringUtils.hasLength(companyDto.getName())) {
            errors.add("Fill name");
        }
        if (!StringUtils.hasLength(companyDto.getDescription())) {
            errors.add("Fill description");
        }
        if (!StringUtils.hasLength(companyDto.getTaxCode())) {
            errors.add("Fill tax code");
        }
        if (!StringUtils.hasLength(companyDto.getEmail())) {
            errors.add("Fill email");
        }
        if (!StringUtils.hasLength(companyDto.getPhone())) {
            errors.add("Fill phone");
        }
        if (companyDto.getAddressDto() == null) {
            errors.add("Fill the address");
        } else {
            if (!StringUtils.hasLength(companyDto.getAddressDto().getAddress1())) {
                errors.add("Fill the address 1");
            }
            if (!StringUtils.hasLength(companyDto.getAddressDto().getCountry())) {
                errors.add("Fill the country");
            }
            if (!StringUtils.hasLength(companyDto.getAddressDto().getCity())) {
                errors.add("Fill the city");
            }
            if (!StringUtils.hasLength(companyDto.getAddressDto().getZipCode())) {
                errors.add("Fill the zip code");
            }
        }

        return errors;
    }
}
