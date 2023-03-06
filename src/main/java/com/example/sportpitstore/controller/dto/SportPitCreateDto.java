package com.example.sportpitstore.controller.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SportPitCreateDto {
    private String name;
    private String manufacture;
    private double price;
    private Long categoryId;
    private Integer quantity;
}