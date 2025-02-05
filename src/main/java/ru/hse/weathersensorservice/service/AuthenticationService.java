package ru.hse.weathersensorservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.hse.weathersensorservice.dto.JwtAuthenticationResponse;
import ru.hse.weathersensorservice.dto.SignInRequest;
import ru.hse.weathersensorservice.dto.SignUpRequest;
import ru.hse.weathersensorservice.entity.Role;
import ru.hse.weathersensorservice.entity.SensorEntity;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final SensorService sensorService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse register(SignUpRequest request) {

        SensorEntity sensorEntity = SensorEntity.builder()
                .name(request.getName())
                .role(Role.SENSOR)
                .build();

        sensorService.create(sensorEntity);

        String jwt = jwtService.generateToken(sensorEntity);
        return new JwtAuthenticationResponse(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getName(),
                request.getPassword()
        ));

        var sensor = sensorService
                .sensorDetailsService()
                .loadUserByUsername(request.getName());

        String jwt = jwtService.generateToken(sensor);
        return new JwtAuthenticationResponse(jwt);
    }
}