package com.kiranpariyar.drones.repository;

import com.kiranpariyar.drones.entity.Drone;
import com.kiranpariyar.drones.enums.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DroneRepository extends CrudRepository<Drone, Integer> {

    List<Drone> findAllByState(State state);
}
