package ru.hse.weathersensorservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.weathersensorservice.dto.JwtAuthenticationResponse;
import ru.hse.weathersensorservice.dto.SignInRequest;
import ru.hse.weathersensorservice.dto.SignUpRequest;
import ru.hse.weathersensorservice.service.AuthenticationService;

@RestController
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    private final String REGISTRATION = "sensors/registration";
    private final String SIGN_IN = "sensors/sign-in";

    @Operation(summary = "sensor registration")
    @PostMapping(REGISTRATION)
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.register(request);
    }

    @Operation(summary = "sensor sign-in")
    @PostMapping(SIGN_IN)
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }

}

