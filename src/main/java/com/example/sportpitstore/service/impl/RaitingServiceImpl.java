package com.example.sportpitstore.service.impl;

import com.example.sportpitstore.controller.dto.RaitingCreateDto;
import com.example.sportpitstore.model.SportPit;
import com.example.sportpitstore.model.Raiting;
import com.example.sportpitstore.repository.SportPitRepository;
import com.example.sportpitstore.repository.RaitingRepository;
import com.example.sportpitstore.service.SportPitService;
import com.example.sportpitstore.service.OrderService;
import com.example.sportpitstore.service.RaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaitingServiceImpl implements RaitingService {
    private final RaitingRepository raitingRepository;
    private final SportPitService sportPitService;

    @Override
    public Raiting addRaiting(RaitingCreateDto raitingDto) throws Exception {
        Raiting raiting = new Raiting();
        raiting.setRaitingValue(raitingDto.getRaitingValue());
        raiting.setSportPit(sportPitService.getById(raitingDto.getSportPitId()));
        return raitingRepository.save(raiting);
    }

    @Override
    public List<Raiting> getRaitingsForEntity(Long sportPitId) throws Exception {
        return raitingRepository.findAllBySportPit_Id(sportPitId);
    }

    @Override
    public Double calculateAverageRaiting(Long sportPitId) throws Exception {
        List<Raiting> raitings = getRaitingsForEntity(sportPitId);
        if (raitings.isEmpty()) {
            return 0.0;
        }
        double sum = raitings.stream().mapToDouble(Raiting::getRaitingValue).sum();
        return sum / raitings.size();
    }

    @Override
    public void delete(Long id) {
        raitingRepository.deleteById(id);
    }
}

