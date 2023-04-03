package com.example.sportpitstore.controller;

import com.example.sportpitstore.controller.dto.OrderCreateDto;
import com.example.sportpitstore.controller.dto.RaitingCreateDto;
import com.example.sportpitstore.model.Order;
import com.example.sportpitstore.model.Raiting;
import com.example.sportpitstore.repository.OrderRepository;
import com.example.sportpitstore.repository.RaitingRepository;
import com.example.sportpitstore.service.OrderService;
import com.example.sportpitstore.service.RaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RaitingController {
    private final RaitingRepository raitingRepository;
    private final RaitingService raitingService;

    @GetMapping("/api/raiting/getavgrate/{sportPitId}")
    public Double calculateAverageRaiting(@PathVariable Long sportPitId) throws Exception {
        return raitingService.calculateAverageRaiting(sportPitId);
    }

    @PostMapping("/api/raiting/addrate")
    public ResponseEntity<?> addRating(@RequestBody RaitingCreateDto raitingDto) throws Exception {
        Double value = raitingService.addRaiting(raitingDto).getRaitingValue();
        return ResponseEntity.ok().body("Raiting is add - " + value);
    }

    @DeleteMapping("api/raiting/delrate/{id}")
    public ResponseEntity<?> delete(Long id) {
        raitingService.delete(id);
        return ResponseEntity.ok().body("Raiting del");
    }

    @GetMapping("api/raiting/getraiting/{sportPitId}")
    public List<Raiting> getRaitingsForEntity(@PathVariable Long sportPitId) throws Exception {
        return raitingService.getRaitingsForEntity(sportPitId);
    }
}
