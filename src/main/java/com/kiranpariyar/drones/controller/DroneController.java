package com.kiranpariyar.drones.controller;

import com.kiranpariyar.drones.dto.DroneDto;
import com.kiranpariyar.drones.dto.MedicationDto;
import com.kiranpariyar.drones.service.DroneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drones")
public class DroneController {

    @Autowired
    private DroneService droneService;


    @PostMapping("/register")
    public ResponseEntity<DroneDto> register(@RequestBody @Valid DroneDto droneDto) {
        return ResponseEntity.ok().body(droneService.register(droneDto));
    }


    @PostMapping("/{id}/load")
    public ResponseEntity<DroneDto> load(@PathVariable("id") int id, @Valid @RequestBody MedicationDto requestBody) {
        return ResponseEntity.ok().body(droneService.load(id, requestBody));
    }

    @GetMapping("/{id}/medications")
    public ResponseEntity<List<MedicationDto>> load(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(droneService.getMedications(id));
    }

}
