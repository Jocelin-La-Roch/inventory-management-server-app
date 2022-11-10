package com.jocelinlaroch08.inventorymanagement.service;

import com.jocelinlaroch08.inventorymanagement.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto save(RoleDto roleDto);

    RoleDto findById(Integer id);

    RoleDto findByCode(String code);

    List<RoleDto> findAll();

    void delete(Integer id);

}
