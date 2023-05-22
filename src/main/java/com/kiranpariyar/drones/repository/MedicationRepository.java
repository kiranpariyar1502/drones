package com.kiranpariyar.drones.repository;

import com.kiranpariyar.drones.entity.Drone;
import com.kiranpariyar.drones.entity.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicationRepository extends CrudRepository<Medication, Integer> {
}
