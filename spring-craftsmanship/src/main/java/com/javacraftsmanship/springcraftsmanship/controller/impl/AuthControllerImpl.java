package com.javacraftsmanship.springcraftsmanship.controller.impl;

import com.javacraftsmanship.springcraftsmanship.controller.AuthController;
import com.javacraftsmanship.springcraftsmanship.dto.request.LoginRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.request.RegisterRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.JWTAuthResponseDto;
import com.javacraftsmanship.springcraftsmanship.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class AuthControllerImpl implements AuthController {

    private AuthService authService;

    public ResponseEntity<JWTAuthResponseDto> login( LoginRequestDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponseDto jwtAuthResponse = new JWTAuthResponseDto();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    public ResponseEntity<String> register( RegisterRequestDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}