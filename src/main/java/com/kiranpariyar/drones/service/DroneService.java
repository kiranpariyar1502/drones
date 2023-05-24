package com.kiranpariyar.drones.service;

import com.kiranpariyar.drones.dto.DroneDto;
import com.kiranpariyar.drones.dto.MedicationDto;
import com.kiranpariyar.drones.entity.Drone;
import com.kiranpariyar.drones.entity.Medication;
import com.kiranpariyar.drones.enums.State;
import com.kiranpariyar.drones.exception.DroneWeightLimitException;
import com.kiranpariyar.drones.exception.EntityNotFoundException;
import com.kiranpariyar.drones.mapper.DroneMapper;
import com.kiranpariyar.drones.mapper.MedicationMapper;
import com.kiranpariyar.drones.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private DroneMapper droneMapper;

    @Autowired
    private MedicationMapper medicationMapper;


    public Drone save(Drone drone) {
        return droneRepository.save(drone);
    }

    public Drone findById(int id) {
        return droneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Drone with given id not found."));
    }

    public DroneDto register(DroneDto droneDto) {
        Drone drone = droneMapper.toEntity(droneDto);
        return droneMapper.toDto(save(drone));
    }

    public DroneDto load(int id, MedicationDto medicationDto) throws EntityNotFoundException {
        Drone drone = findById(id);
        Medication medication = medicationMapper.toEntity(medicationDto);

        if (weightIsNotAcceptable(drone, medication)) {
            throw new DroneWeightLimitException("Maximum allowed weight for medications is " + drone.getWeightLimit());
        }

        Set<Medication> medications = new HashSet<>();
        Set<Medication> loadedMedications = drone.getMedications();
        if (loadedMedications != null && !loadedMedications.isEmpty()) {
            medications.addAll(loadedMedications);
        }
        medications.add(medication);
        drone.setMedications(medications);
        drone.setState(State.LOADED);
        return droneMapper.toDto(save(drone));
    }


    public List<MedicationDto> getMedications(int droneId) {
        Drone drone = findById(droneId);
        return drone.getMedications().stream()
                .map(medication -> medicationMapper.toDto(medication))
                .collect(Collectors.toList());
    }

    private boolean weightIsNotAcceptable(Drone drone, Medication requestedMedication) {
        double requestedMedicationsWeight = requestedMedication.getWeight();
        double existedMedicationWeight = drone.getMedications().stream().mapToDouble(Medication::getWeight).sum();
        return requestedMedicationsWeight + existedMedicationWeight > drone.getWeightLimit();
    }

    public List<DroneDto> getAvailable() {
        return droneRepository.findAllByState(State.IDLE).stream()
                .map(drone -> droneMapper.toDto(drone))
                .collect(Collectors.toList());
    }
}
