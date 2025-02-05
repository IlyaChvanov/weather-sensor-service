package ru.hse.weathersensorservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {
    @NotBlank(message = "name can not be empty")
    private String name;

    public String getPassword() {
        return "";
    }
}
