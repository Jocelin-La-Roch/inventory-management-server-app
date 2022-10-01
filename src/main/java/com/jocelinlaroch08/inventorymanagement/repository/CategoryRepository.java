package com.jocelinlaroch08.inventorymanagement.repository;

import com.jocelinlaroch08.inventorymanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
