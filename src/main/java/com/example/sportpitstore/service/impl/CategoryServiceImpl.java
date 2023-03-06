package com.example.sportpitstore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.sportpitstore.controller.dto.CategoryCreateDto;
import com.example.sportpitstore.model.Category;
import com.example.sportpitstore.repository.CategoryRepository;
import com.example.sportpitstore.service.CategoryService;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryCreateDto createDto) {
        Category category = new Category();
        category.setName(createDto.getName());

        return categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}