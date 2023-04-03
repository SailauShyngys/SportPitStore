package com.example.sportpitstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "raitings")
@Getter
@Setter
public class Raiting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double raitingValue;
    @ManyToOne
    @JoinColumn(name = "sportPit_id")
    private SportPit sportPit;
}