package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.Company;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CompanyDto {

    private Integer id;

    private String name;

    private String description;
    private AddressDto addressDto;

    private String taxCode;

    private String photo;

    private String email;

    private String phone;

    private String website;

    private List<UserDto> userDtoList;

    public CompanyDto fromEntity(Company company) {
        if (company == null) {
            return null;
        }

        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .addressDto(this.addressDto.fromEntity(company.getAddress()))
                .taxCode(company.getTaxCode())
                .photo(company.getPhoto())
                .email(company.getEmail())
                .phone(company.getPhone())
                .website(company.getWebsite())
                .build();
    }

    public Company toEntity(CompanyDto companyDto) {
        if (companyDto == null) {
           return null;
        }

        Company company = new Company();

        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());
        company.setAddress(this.addressDto.toEntity(companyDto.getAddressDto()));
        company.setTaxCode(companyDto.getTaxCode());
        company.setPhoto(companyDto.getPhoto());
        company.setEmail(companyDto.getEmail());
        company.setWebsite(companyDto.getWebsite());

        return company;
    }

}
