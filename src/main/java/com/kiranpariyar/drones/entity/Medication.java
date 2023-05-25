package com.kiranpariyar.drones.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private float weight;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "image")
    private String image;

}
