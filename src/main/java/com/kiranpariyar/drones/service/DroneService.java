package com.kiranpariyar.drones.service;

import com.kiranpariyar.drones.entity.Drone;
import com.kiranpariyar.drones.entity.Medication;
import com.kiranpariyar.drones.enums.State;
import com.kiranpariyar.drones.exception.EntityNotFoundException;
import com.kiranpariyar.drones.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    public Drone register(Drone drone) {
        return droneRepository.save(drone);
    }

    public Drone load(int id, Set<Medication> medications) throws EntityNotFoundException {
        Drone drone = droneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Drone with given id not found."));
        drone.setMedications(medications);
        drone.setState(State.LOADED);
        return droneRepository.save(drone);
    }
}
