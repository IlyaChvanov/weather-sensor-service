package ru.hse.weathersensorservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.weathersensorservice.dto.MeasurementDto;
import ru.hse.weathersensorservice.service.MeasurementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MeasurementController {
    private final MeasurementService measurementService;

    private final String ADD_MEASUREMENT = "/measurements/add";
    private final String GET_MEASUREMENT = "/measurements";
    private final String GET_RAINY_DAYS = "/measurements/DaysCount";

    @PostMapping(ADD_MEASUREMENT)
    public MeasurementDto addMeasurement(@RequestBody @Valid MeasurementDto measurementDto) {
        return measurementService.add(measurementDto);
    }

    @GetMapping(GET_MEASUREMENT)
    public List<MeasurementDto> getAllMeasurements() {
        return measurementService.getAll();
    }

    @GetMapping(GET_RAINY_DAYS)
    public Long getRainDaysCount() {
        return measurementService.CountRainingDays();
    }
}
