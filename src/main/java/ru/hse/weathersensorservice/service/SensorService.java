package ru.hse.weathersensorservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.hse.weathersensorservice.entity.SensorEntity;

public interface SensorService {
    SensorEntity save(SensorEntity SensorEntity);

    SensorEntity create(SensorEntity SensorEntity);

    UserDetailsService sensorDetailsService();
}