package com.example.sportpitstore.service;

import com.example.sportpitstore.controller.dto.SportPitCreateDto;
import com.example.sportpitstore.model.SportPit;
public interface SportPitService {
    SportPit getById(Long id) throws Exception;
    SportPit createSportPit(SportPitCreateDto createDto);
}