package com.javacraftsmanship.springcraftsmanship.controller;

import com.javacraftsmanship.springcraftsmanship.dto.request.LoginRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.request.RegisterRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.JWTAuthResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.javacraftsmanship.springcraftsmanship.utils.ApiPaths.*;
import static com.javacraftsmanship.springcraftsmanship.utils.AppConstants.*;

@RestController
@RequestMapping(API + V1 + AUTH)
public interface AuthController {
    @PostMapping(value = {LOGIN, SIGN_IN})
     ResponseEntity<JWTAuthResponseDto> login(@RequestBody LoginRequestDto loginDto);

    @PostMapping(value = {REGISTER,SIGN_UP})
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerDto);
}
