package com.example.sportpitstore.service;

import com.example.sportpitstore.controller.dto.RaitingCreateDto;
import com.example.sportpitstore.model.Raiting;

import java.util.List;

public interface RaitingService {
    Raiting addRaiting(RaitingCreateDto raitingDto) throws Exception;

    List<Raiting> getRaitingsForEntity(Long sportPitId) throws Exception;

    Double calculateAverageRaiting(Long sportPitId) throws Exception;

    void delete(Long id);
}
