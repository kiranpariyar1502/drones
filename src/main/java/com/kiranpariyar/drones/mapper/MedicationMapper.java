package com.kiranpariyar.drones.mapper;

import com.kiranpariyar.drones.dto.MedicationDto;
import com.kiranpariyar.drones.entity.Medication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MedicationMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public MedicationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Medication toEntity(MedicationDto medicationDto) {
        return modelMapper.map(medicationDto, Medication.class);
    }

    public MedicationDto toDto(Medication medication) {
        return modelMapper.map(medication, MedicationDto.class);
    }

    public Set<Medication> toEntitySet(List<MedicationDto> medicationDtoList) {
        return medicationDtoList.stream()
                .map(medicationDto -> modelMapper.map(medicationDto, Medication.class))
                .collect(Collectors.toSet());
    }

    public Set<MedicationDto> toDtoList(List<Medication> medications) {
        return medications.stream()
                .map(medication -> modelMapper.map(medication, MedicationDto.class))
                .collect(Collectors.toSet());
    }


}
