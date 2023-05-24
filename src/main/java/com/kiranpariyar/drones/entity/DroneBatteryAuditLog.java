package com.kiranpariyar.drones.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "drone_battery_audit_log")
public class DroneBatteryAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "drone_id", nullable = false)
    private Integer droneId;

    @Column(name = "event_time", nullable = false)
    private Instant eventTime;

    @Column(name = "battery_level", nullable = false)
    private int batteryLevel;

    @Column(name = "event_description")
    private String eventDescription;


}
