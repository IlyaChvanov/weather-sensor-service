package ru.hse.weathersensorservice.dto;

import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MeasurementDto {
    Double value;

    Boolean raining;

    @ManyToOne
    SensorDto sensor;
}
