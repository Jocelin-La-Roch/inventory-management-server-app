package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.RoleDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RoleApi {

    @PostMapping(value = Utils.APP_ROOT + "/roles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDto save(@RequestBody RoleDto roleDto);

    @GetMapping(value = Utils.APP_ROOT+"/roles/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDto findById(@PathVariable("roleId") Integer id);

    /*@GetMapping(value = Utils.APP_ROOT+"/roles/{roleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDto findByCode(@PathVariable("roleCode") String code);*/

    @GetMapping(value = Utils.APP_ROOT+"/roles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RoleDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/roles/delete/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("roleId") Integer id);

}
