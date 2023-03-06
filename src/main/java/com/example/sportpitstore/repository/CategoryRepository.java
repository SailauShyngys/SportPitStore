package com.example.sportpitstore.repository;

import com.example.sportpitstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
