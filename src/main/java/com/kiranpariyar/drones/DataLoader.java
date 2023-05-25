package com.kiranpariyar.drones;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiranpariyar.drones.entity.Drone;
import com.kiranpariyar.drones.service.DroneService;
import com.kiranpariyar.drones.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {


    @Autowired
    private DroneService droneService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(String... args) {
        try {
            String dataAsString = FileUtils.readAsStringFromResource("data/drones.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Drone> drones = objectMapper.readValue(dataAsString, new TypeReference<>(){});
            drones.forEach(drone -> droneService.save(drone));
        } catch (Exception ex) {
            log.error("Exception while loading data." + ex);
            throw new RuntimeException(ex);
        }
    }
}
