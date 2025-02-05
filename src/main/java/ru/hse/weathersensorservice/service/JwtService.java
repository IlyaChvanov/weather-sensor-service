package ru.hse.weathersensorservice.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(UserDetails userDetails);

    String extractUserName(String token);
}
