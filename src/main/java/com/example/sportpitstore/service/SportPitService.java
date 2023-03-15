package com.example.sportpitstore.service;

import com.example.sportpitstore.controller.dto.SportPitCreateDto;
import com.example.sportpitstore.model.SportPit;
import java.util.List;
public interface SportPitService {
    SportPit getById(Long id)throws Exception;
    List<SportPit> getByIdSportPit(List<Long> id)throws Exception;

    SportPit createSportPit(SportPitCreateDto createDto) throws Exception;
    void deleteSportPit(Long id)throws Exception;
    SportPit updateSportPit(Long id,SportPitCreateDto createDto)throws  Exception;
}