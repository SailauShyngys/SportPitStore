package com.example.sportpitstore.service.impl;

import com.example.sportpitstore.service.SportPitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.sportpitstore.controller.dto.SportPitCreateDto;
import com.example.sportpitstore.model.SportPit;
import com.example.sportpitstore.repository.SportPitRepository;
import com.example.sportpitstore.service.CategoryService;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
    public List<SportPit> getByIdSportPit(List<Long> id) {
        return sportPitRepository.findAllById(id).stream().toList();
    }

    @Override
    public SportPit createSportPit(SportPitCreateDto createDto) throws Exception {
        SportPit sportPit = new SportPit();
        sportPit.setName(createDto.getName());
        sportPit.setManufacture(createDto.getManufacture());
        sportPit.setPrice(createDto.getPrice());
        sportPit.setCharacterization(createDto.getCharacterization());
        sportPit.setQuantity(createDto.getQuantity());
        sportPit.setCategory(categoryService.getById(createDto.getCategoryId()));
        return sportPitRepository.save(sportPit);
    }

    @Override
    public void deleteSportPit(Long id) throws Exception {
        sportPitRepository.deleteById(id);
    }

    public SportPit updateSportPit(Long id, SportPitCreateDto createDto) throws Exception {
        SportPit sportPit = sportPitRepository.findById(id).orElseThrow();
        if (id != null) {
            sportPit.setName(createDto.getName());
            sportPit.setQuantity(createDto.getQuantity());
            sportPit.setPrice(createDto.getPrice());
            sportPit.setCategory(categoryService.getById(createDto.getCategoryId()));
        }
        return sportPitRepository.save(sportPit);
    }
}