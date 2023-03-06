package com.example.sportpitstore.service;

import com.example.sportpitstore.controller.dto.CategoryCreateDto;
import com.example.sportpitstore.model.Category;

public interface CategoryService {
    Category create(CategoryCreateDto createDto);
    Category getById(Long id);
}