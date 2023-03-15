package com.example.sportpitstore.controller;

import com.example.sportpitstore.controller.dto.CategoryCreateDto;
import com.example.sportpitstore.model.Category;
import com.example.sportpitstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/api/categories/{id}")
    public Category getById(@PathVariable Long id) throws Exception {
        return categoryService.getById(id);
    }
    @PostMapping("/api/categories")
    public Long createCoffee(@RequestBody CategoryCreateDto createDto) {
        return categoryService.createCategory(createDto.getName());
    }
    @PutMapping("/api/categories/{id}")
    public Category updateCategory( @PathVariable Long id,@RequestBody CategoryCreateDto createDto) throws Exception {
        return categoryService.updateCategory(id,createDto.getName());
    }
    @DeleteMapping ("/api/categories/{id}")
    public void deleteCategory( @PathVariable Long id) throws Exception {
        categoryService.deleteCategory(id);
    }
}