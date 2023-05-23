package com.kiranpariyar.drones.mapper;

import com.kiranpariyar.drones.dto.DroneDto;
import com.kiranpariyar.drones.entity.Drone;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DroneMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public DroneMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Drone toEntity(DroneDto droneDto) {
        return modelMapper.map(droneDto, Drone.class);
    }

    public DroneDto toDto(Drone drone) {
        return modelMapper.map(drone, DroneDto.class);
    }
}
