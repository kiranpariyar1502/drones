package com.kiranpariyar.drones.repository;

import com.kiranpariyar.drones.entity.Drone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DroneRepository extends CrudRepository<Drone, Integer> {
}
