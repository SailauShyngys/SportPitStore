package com.example.sportpitstore.controller.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SportPitCreateDto {
    private String name;
    private String manufacture;
    private Integer price;
    private Integer quantity;
    private Long categoryId;
    private String characterization;
}