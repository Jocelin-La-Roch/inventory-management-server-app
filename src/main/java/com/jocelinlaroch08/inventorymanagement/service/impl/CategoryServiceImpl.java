package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.CategoryDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.Category;
import com.jocelinlaroch08.inventorymanagement.repository.CategoryRepository;
import com.jocelinlaroch08.inventorymanagement.service.CategoryService;
import com.jocelinlaroch08.inventorymanagement.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);

        if(!errors.isEmpty()) {
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("Category is not valid", ErrorCode.CATEGORY_NOT_VALID, errors);
        }

        Category savedCategory = categoryRepository.save(CategoryDto.toEntity(categoryDto));

        return CategoryDto.fromEntity(savedCategory);
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }

        Optional<Category> category = categoryRepository.findById(id);

        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());

        return Optional.of(categoryDto).orElseThrow(() -> new EntityNotFoundException("No category found", ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (code == null) {
            log.error("Code is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findByCode(code);

        CategoryDto articleDto = CategoryDto.fromEntity(category.get());

        return Optional.of(articleDto).orElseThrow(() -> new EntityNotFoundException("No category found", ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return;
        }
        categoryRepository.deleteById(id);
    }
}
