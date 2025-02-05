package ru.hse.weathersensorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.weathersensorservice.entity.SensorEntity;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long> {
    boolean existsByName(String name);

    Optional<SensorEntity> findByName(String name);
}
