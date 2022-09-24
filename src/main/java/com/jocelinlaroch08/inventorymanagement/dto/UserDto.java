package com.jocelinlaroch08.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jocelinlaroch08.inventorymanagement.model.Address;
import com.jocelinlaroch08.inventorymanagement.model.Company;
import com.jocelinlaroch08.inventorymanagement.model.Role;
import com.jocelinlaroch08.inventorymanagement.model.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UserDto {

    private Integer id;

    private String firstname;

    private String lastname;

    private AddressDto addressDto;

    private String photo;

    private String email;

    private String phone;

    private String password;

    private Instant birthDate;

    private CompanyDto companyDto;

    @JsonIgnore
    private List<RoleDto> roleDtoList;

    public UserDto fromEntity(User user) {
        if (user == null) {
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .addressDto(this.addressDto.fromEntity(user.getAddress()))
                .birthDate(user.getBirthDate())
                .phone(user.getPhone())
                .photo(user.getPhoto())
                .email(user.getEmail())
                .companyDto(this.companyDto.fromEntity(user.getCompany()))
                .build();
    }

    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setBirthDate(userDto.getBirthDate());
        user.setPhone(userDto.getPhone());
        user.setPhoto(userDto.getPhoto());
        user.setEmail(userDto.getEmail());
        user.setAddress(this.addressDto.toEntity(userDto.getAddressDto()));
        user.setCompany(this.companyDto.toEntity(userDto.getCompanyDto()));

        return user;
    }

}
