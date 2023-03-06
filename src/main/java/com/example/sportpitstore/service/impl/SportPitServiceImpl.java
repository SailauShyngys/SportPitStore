package com.example.sportpitstore.service.impl;

import com.example.sportpitstore.service.SportPitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.sportpitstore.controller.dto.SportPitCreateDto;
import com.example.sportpitstore.model.SportPit;
import com.example.sportpitstore.repository.SportPitRepository;
import com.example.sportpitstore.service.CategoryService;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SportPitServiceImpl implements SportPitService {
    private final SportPitRepository sportPitRepository;
    private final CategoryService categoryService;

    @Override
    public SportPit getById(Long id) {
        return sportPitRepository.findById(id).orElseThrow();
    }

    @Override
    public SportPit createSportPit(SportPitCreateDto createDto) {
        SportPit sportPit = new SportPit();
        sportPit.setName(createDto.getName());
        sportPit.setManufacture(createDto.getManufacture());
        sportPit.setCategory(categoryService.getById(createDto.getCategoryId()));
        sportPit.setPrice(createDto.getPrice());
        sportPit.setQuantity(createDto.getQuantity());

        return sportPitRepository.save(sportPit);
    }
}