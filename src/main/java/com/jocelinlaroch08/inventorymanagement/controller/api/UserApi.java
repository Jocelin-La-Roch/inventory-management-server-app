package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.UserDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserApi {

    @PostMapping(value = Utils.APP_ROOT + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto save(@RequestBody UserDto userDto);

    @GetMapping(value = Utils.APP_ROOT+"/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto findById(@PathVariable("userId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/users/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("userId") Integer id);

}
