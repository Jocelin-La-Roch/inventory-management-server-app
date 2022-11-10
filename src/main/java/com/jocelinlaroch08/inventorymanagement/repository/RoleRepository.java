package com.jocelinlaroch08.inventorymanagement.repository;

import com.jocelinlaroch08.inventorymanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByCode(String code);

}
