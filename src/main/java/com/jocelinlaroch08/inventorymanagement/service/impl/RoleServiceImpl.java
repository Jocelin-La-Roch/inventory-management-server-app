package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.RoleDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.Role;
import com.jocelinlaroch08.inventorymanagement.repository.RoleRepository;
import com.jocelinlaroch08.inventorymanagement.service.RoleService;
import com.jocelinlaroch08.inventorymanagement.validator.RoleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        List<String> errors = RoleValidator.validate(roleDto);
        if(!errors.isEmpty()) {
            log.error("Role is not valid {}", roleDto);
            throw new InvalidEntityException("Role is not valid", ErrorCode.ROLE_NOT_VALID, errors);
        }
        Role savedRole = roleRepository.save(RoleDto.toEntity(roleDto));
        return RoleDto.fromEntity(savedRole);
    }

    @Override
    public RoleDto findById(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }

        Optional<Role> role = roleRepository.findById(id);

        RoleDto roleDto = RoleDto.fromEntity(role.get());

        return Optional.of(roleDto).orElseThrow(() -> new EntityNotFoundException("No role found", ErrorCode.ARTICLE_NOT_FOUND));
    }

    /*@Override
    public RoleDto findByCode(String code) {
        if (code == null) {
            log.error("Code is null");
            return null;
        }
        Optional<Role> role = roleRepository.findByCode(code);

        RoleDto roleDto = RoleDto.fromEntity(role.get());

        return Optional.of(roleDto).orElseThrow(() -> new EntityNotFoundException("No role found", ErrorCode.ARTICLE_NOT_FOUND));
    }*/

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream().map(RoleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return;
        }
        roleRepository.deleteById(id);
    }
}
