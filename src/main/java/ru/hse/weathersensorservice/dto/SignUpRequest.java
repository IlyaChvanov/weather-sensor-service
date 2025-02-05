package ru.hse.weathersensorservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpRequest {
    @NotBlank(message = "name can not be empty")
    private String name;
}
