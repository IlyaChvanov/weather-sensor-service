package ru.hse.weathersensorservice.service;

import ru.hse.weathersensorservice.dto.MeasurementDto;

import java.util.List;

public interface MeasurementService {
    MeasurementDto add(MeasurementDto measurementDto);

    List<MeasurementDto> getAll();

    Long CountRainingDays();

}
