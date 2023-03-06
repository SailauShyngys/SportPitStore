package com.example.sportpitstore.service;

import com.example.sportpitstore.controller.dto.SportPitCreateDto;
import com.example.sportpitstore.model.SportPit;
import com.example.sportpitstore.model.Category;
import com.example.sportpitstore.repository.SportPitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
@DisplayName("Должен ")
public class SportPitServiceTest {
    @Autowired
    private SportPitService sportPitService;
    @MockBean
    private CategoryService categoryService;
    @MockBean
    private SportPitRepository sportPitRepository;

    @Test
    @DisplayName("корректно возвращать товар")
    void createSportPitTest() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Protein");

        SportPitCreateDto createDto = new SportPitCreateDto();
        createDto.setName("WheyProtein");
        createDto.setManufacture("OptimumOn");
        createDto.setPrice(3.55);
        createDto.setQuantity(700);
        createDto.setCategoryId(category.getId());

        SportPit sportPit = new SportPit();
        sportPit.setCategory(category);
        sportPit.setQuantity(700);
        sportPit.setManufacture("OptimumOn");
        sportPit.setName("WheyProtein");
        sportPit.setId(1L);

        Mockito.when(categoryService.getById(2L)).thenReturn(category);
        Mockito.when(sportPitRepository.save(Mockito.any(SportPit.class))).thenReturn(sportPit);

        var res = sportPitService.createSportPit(createDto);

        Assertions.assertEquals(res.getName(), "WheyProtein");
        Assertions.assertEquals(res.getManufacture(), "OptimumOn");
        Assertions.assertEquals(res.getCategory().getName(), "Protein");
        Assertions.assertEquals(res.getQuantity(), 700);
    }
}