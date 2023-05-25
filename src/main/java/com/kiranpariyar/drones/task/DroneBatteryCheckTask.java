package com.kiranpariyar.drones.task;

import com.kiranpariyar.drones.entity.Drone;
import com.kiranpariyar.drones.entity.DroneBatteryAuditLog;
import com.kiranpariyar.drones.repository.DroneBatteryAuditLogRepository;
import com.kiranpariyar.drones.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@EnableScheduling
public class DroneBatteryCheckTask {

    @Autowired
    private DroneBatteryAuditLogRepository droneBatteryAuditLogRepository;

    @Autowired
    private DroneService droneService;

    @Scheduled(initialDelay = 30, fixedRate = 60, timeUnit = TimeUnit.SECONDS)
    public void checkDroneBatteryLevels() {
        log.info("Checking Drone battery level.");
        Iterable<Drone> drones = droneService.findAll();
        drones.forEach(drone -> {
            DroneBatteryAuditLog auditLog = new DroneBatteryAuditLog();
            auditLog.setDroneId(drone.getId());
            auditLog.setEventTime(Instant.now());
            auditLog.setBatteryLevel(drone.getBatteryLevel());
            auditLog.setEventDescription("Battery level checked.");
            droneBatteryAuditLogRepository.save(auditLog);
            log.info("Audit log saved for drone Id." + drone.getId());
        });
    }
}
