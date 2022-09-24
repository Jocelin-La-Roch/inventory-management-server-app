package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {

    private Integer id;

    private String label;

    private UserDto userDto;

    public static RoleDto fromEntity(Role role) {
        if (role == null) {
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .label(role.getLabel())
                .userDto(UserDto.fromEntity(role.getUser()))
                .build();
    }

    public static Role toEntity(RoleDto roleDto) {
        if (roleDto == null) {
           return null;
        }

        Role role = new Role();
        role.setId(roleDto.getId());
        role.setUser(UserDto.toEntity(roleDto.getUserDto()));
        role.setLabel(roleDto.getLabel());

        return role;

    }

}
