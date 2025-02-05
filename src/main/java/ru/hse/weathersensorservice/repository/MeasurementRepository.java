package ru.hse.weathersensorservice.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.weathersensorservice.entity.MeasurementEntity;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Long> {
    List<MeasurementEntity> findAll();
    Long countAllByRaining(@NonNull Boolean raining);
}
