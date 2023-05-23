package com.kiranpariyar.drones.dto;


import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MedicationDto {

    private int id;

    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Invalid medication name. Allowed characters are letters, numbers, ‘-‘, ‘_’")
    private String name;

    private float weight;

    @Pattern(regexp = "^[A-Z0-9_]+$", message = "Invalid medication code. Allowed only upper case letters, underscore and numbers")
    private String code;

    private String image;

}
