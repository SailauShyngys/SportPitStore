package com.example.sportpitstore.controller;

import com.example.sportpitstore.controller.dto.SportPitCreateDto;
import com.example.sportpitstore.model.SportPit;
import com.example.sportpitstore.service.SportPitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SportPitController {
    private final SportPitService sportPitService;

    @GetMapping("/api/sportPits/{id}")
    public SportPit getById(@PathVariable Long id) throws Exception {
        return sportPitService.getById(id);
    }

    @PostMapping("/api/sportPits")
    public ResponseEntity<?> createSportPit(@RequestBody SportPitCreateDto createDto) {
        String name = sportPitService
                .createSportPit(createDto).getName();

        return ResponseEntity.ok().body("SportPit saved - " + name);
    }
}