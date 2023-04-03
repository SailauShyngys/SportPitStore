package com.example.sportpitstore.service.impl;

import org.springframework.stereotype.Service;
import com.example.sportpitstore.model.Category;
import com.example.sportpitstore.repository.CategoryRepository;
import com.example.sportpitstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public Long createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category).getId();
    }

    @Override
    public Category updateCategory(Long id, String name) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}