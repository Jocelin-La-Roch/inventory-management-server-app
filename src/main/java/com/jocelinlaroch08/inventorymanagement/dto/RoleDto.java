package com.jocelinlaroch08.inventorymanagement.dto;

import com.jocelinlaroch08.inventorymanagement.model.Role;
import com.jocelinlaroch08.inventorymanagement.model.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {

    private Integer id;

    private String label;

    private UserDto userDto;

    public RoleDto fromEntity(Role role) {
        if (role == null) {
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .label(role.getLabel())
                .userDto(this.userDto.fromEntity(role.getUser()))
                .build();
    }

    public Role toEntity(RoleDto roleDto) {
        if (roleDto == null) {
           return null;
        }

        Role role = new Role();
        role.setId(roleDto.getId());
        role.setUser(this.userDto.toEntity(roleDto.getUserDto()));
        role.setLabel(roleDto.getLabel());

        return role;

    }

}
