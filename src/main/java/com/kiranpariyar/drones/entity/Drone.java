package com.kiranpariyar.drones.entity;


import com.kiranpariyar.drones.enums.Model;
import com.kiranpariyar.drones.enums.State;
import jakarta.persistence.*;

import java.util.Set;

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

    @Column(name = "weight")
    private int weight;

    @Column(name = "battery_level")
    private int batteryLevel;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany
    @JoinColumn(name = "drone_id")
    private Set<Medication> medications;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<Medication> getMedications() {
        return medications;
    }

    public void setMedications(Set<Medication> medications) {
        this.medications = medications;
    }
}
