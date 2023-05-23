package com.kiranpariyar.drones.entity;


import com.kiranpariyar.drones.enums.Model;
import com.kiranpariyar.drones.enums.State;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "drones")
public class Drone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serial_number", length = 100)
    private String serialNumber;

    @Column(name = "model")
    @Enumerated(EnumType.STRING)
    private Model model;

    @Column(name = "weight_limit")
    private float weightLimit;

    @Column(name = "battery_level")
    private int batteryLevel;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "drone_id")
    private Set<Medication> medications;

}
