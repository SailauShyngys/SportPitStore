package com.example.sportpitstore.controller;

import com.example.sportpitstore.controller.dto.SportPitCreateDto;
import com.example.sportpitstore.model.SportPit;
import com.example.sportpitstore.service.SportPitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class SportPitController {
    private final SportPitService sportPitService;

    @GetMapping("/api/sportPits/{id}")
    public SportPit getById(@PathVariable Long id) throws Exception {
        return sportPitService.getById(id);
    }

    @GetMapping("/api/sportPit/{id}")
    public List<SportPit> getByIdSportPit(@PathVariable List<Long> id) throws Exception {
        return sportPitService.getByIdSportPit(id);
    }

    @PostMapping("/api/sportPits")
    public SportPit createSportPit(@RequestBody SportPitCreateDto createDto)throws Exception  {
        return sportPitService.createSportPit(createDto);
    }

    @PutMapping("/api/sportPit/{id}")
    public SportPit updateSportPit(@PathVariable Long id, @RequestBody SportPitCreateDto createDto) throws Exception{
        return sportPitService.updateSportPit(id, createDto);
    }

    @DeleteMapping("/api/sportPit/{id}")
    public void deleteSportPit(@PathVariable Long id) throws Exception{
        sportPitService.deleteSportPit(id);
    }

}