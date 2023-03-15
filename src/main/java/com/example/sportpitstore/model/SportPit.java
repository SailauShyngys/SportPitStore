package com.example.sportpitstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;


@Entity(name = "sportPits")
@Getter
@Setter
public class SportPit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacture;
    private Integer price;
    private String characterization;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany
    private List<Order> sportPitOrders;
    @CreationTimestamp
    private ZonedDateTime createdDate;
    @UpdateTimestamp
    private ZonedDateTime updatedDate;
}