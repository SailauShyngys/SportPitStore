package com.example.sportpitstore.service;

import com.example.sportpitstore.model.Category;

public interface CategoryService {
    Category getById(Long id) throws Exception;

    Long createCategory(String name);

    Category updateCategory(Long id, String name);

    void deleteCategory(Long id) throws Exception;
}