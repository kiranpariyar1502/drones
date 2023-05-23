package com.kiranpariyar.drones.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.kiranpariyar.drones.enums.Model;
import com.kiranpariyar.drones.enums.State;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DroneDto {

    private Integer id;

    @Size(max = 100, message = "Maximum allowed characters is 100")
    private String serialNumber;

    private Model model;

    @Max(value = 500, message = "Maximum allowed wight limit is 500 grams")
    private float weightLimit;

    @Max(value = 100, message = "Maximum value for battery level percentage is 100%")
    private int batteryLevel;

    private State state;

    private Set<MedicationDto> medications;
}
