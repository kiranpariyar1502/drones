package com.kiranpariyar.drones.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private float weight;

    @Column(name = "code")
    private String code;

    @Column(name = "image")
    private String image;

}
