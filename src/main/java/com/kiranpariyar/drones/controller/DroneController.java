package com.kiranpariyar.drones.controller;

import com.kiranpariyar.drones.entity.Drone;
import com.kiranpariyar.drones.entity.Medication;
import com.kiranpariyar.drones.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("drones")
public class DroneController {

    @Autowired
    private DroneService droneService;


    @PostMapping("/register")
    public ResponseEntity<Drone> register(@RequestBody Drone drone) {
        return ResponseEntity.ok().body(droneService.register(drone));
    }


    @PostMapping("/{id}/load")
    public ResponseEntity<Drone> load(@PathVariable("id") int id, @RequestBody List<Medication> medications) {
        Drone drone = droneService.load(id, new HashSet<>(medications));
        return ResponseEntity.ok().body(drone);
    }
}
