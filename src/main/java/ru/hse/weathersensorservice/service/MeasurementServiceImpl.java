package ru.hse.weathersensorservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.weathersensorservice.dto.MeasurementDto;
import ru.hse.weathersensorservice.dto.SensorDto;
import ru.hse.weathersensorservice.entity.MeasurementEntity;
import ru.hse.weathersensorservice.entity.SensorEntity;
import ru.hse.weathersensorservice.repository.MeasurementRepository;
import ru.hse.weathersensorservice.repository.SensorRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Transactional
    public MeasurementDto add(MeasurementDto measurement) {

        SensorEntity sensor = sensorRepository.findByName(measurement.getSensor().getName()).orElseThrow(
                () -> new IllegalArgumentException("Measurement sensor does not exist")
        );

        measurementRepository.save(MeasurementEntity.builder()
                .value(measurement.getValue())
                .raining(measurement.getRaining())
                .sensor(sensor)
                .build());

        return measurement;
    }

    @Transactional
    public List<MeasurementDto> getAll() {
        List<MeasurementEntity> list = measurementRepository.findAll();
        return list.stream()
                .map(entity -> MeasurementDto.builder()
                        .value(entity.getValue())
                        .raining(entity.getRaining())
                        .sensor(SensorDto.builder()
                                .name(entity.getSensor().getName())
                                .build())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public Long CountRainingDays() {
        return measurementRepository.countAllByRaining(true);
    }

}
