package com.example.sportpitstore.repository;

import com.example.sportpitstore.model.Raiting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaitingRepository extends JpaRepository<Raiting, Long> {
    List<Raiting> findAllBySportPit_Id(Long sportPitId);
}
