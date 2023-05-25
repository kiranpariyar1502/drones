package com.kiranpariyar.drones.controller;

import com.kiranpariyar.drones.dto.DroneDto;
import com.kiranpariyar.drones.dto.MedicationDto;
import com.kiranpariyar.drones.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<DroneDto>> register(@RequestBody @Valid DroneDto droneDto) {
        DroneDto savedDroneDto = droneService.register(droneDto);
        ApiResponse<DroneDto> apiResponse = ApiResponse.<DroneDto>success().data(savedDroneDto).build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DroneDto>> findById(@PathVariable("id") int id) {
        DroneDto droneDto = droneService.findByIdAndMapToDto(id);
        ApiResponse<DroneDto> apiResponse = ApiResponse.<DroneDto>success().data(droneDto).build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PostMapping("/{id}/load")
    public ResponseEntity<ApiResponse<DroneDto>> load(@PathVariable("id") int id, @Valid @RequestBody MedicationDto requestBody) {
        DroneDto droneDto = droneService.load(id, requestBody);
        ApiResponse<DroneDto> apiResponse = ApiResponse.<DroneDto>success().data(droneDto).build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping("/{id}/medications")
    public ResponseEntity<ApiResponse<List<MedicationDto>>> getMedications(@PathVariable("id") int id) {
        List<MedicationDto> medications = droneService.getMedications(id);
        ApiResponse<List<MedicationDto>> apiResponse = ApiResponse.<List<MedicationDto>>success().data(medications).build();
        return ResponseEntity.ok().body(apiResponse);
    }


    @GetMapping("/available")
    public ResponseEntity<ApiResponse<List<DroneDto>>> getAvailable() {
        List<DroneDto> availableDrones = droneService.getAvailable();
        ApiResponse<List<DroneDto>> apiResponse = ApiResponse.<List<DroneDto>>success().data(availableDrones).build();
        return ResponseEntity.ok().body(apiResponse);
    }


}
