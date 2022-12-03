package com.jocelinlaroch08.inventorymanagement.controller;

import com.jocelinlaroch08.inventorymanagement.controller.api.RoleApi;
import com.jocelinlaroch08.inventorymanagement.dto.RoleDto;
import com.jocelinlaroch08.inventorymanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController implements RoleApi {
    private RoleService roleService;

    // Constructor Injection
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        return roleService.save(roleDto);
    }

    @Override
    public RoleDto findById(Integer id) {
        return roleService.findById(id);
    }

    /* @Override
    public RoleDto findByCode(String code) {
        return roleService.findByCode(code);
    }*/

    @Override
    public List<RoleDto> findAll() {
        return roleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        roleService.delete(id);
    }
}
