package com.fortunate.nwachukwu.droneservice.util;

import com.fortunate.nwachukwu.droneservice.model.Drone;
import com.fortunate.nwachukwu.droneservice.repository.DroneRepository;
import com.fortunate.nwachukwu.droneservice.service.implementation.DroneServiceImplementation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class DroneBatteryPeriodicCheck {
    private static final Logger log = LoggerFactory.getLogger(DroneServiceImplementation.class);
    private final DroneRepository droneRepository;

    @Scheduled(fixedRate = 10000)
    public void auditDroneBattery() {
        log.info("Running Drone Audit Log at {}", LocalDateTimeConverter.convertLocalDateTime(LocalDateTime.now()));

            Iterable<Drone> drones = droneRepository.findAll();
            drones.forEach(drone ->  log
                    .info("Battery Level for " + drone.getSerialNumber() + " is " + drone.getBatteryCapacity()));
    }
}

