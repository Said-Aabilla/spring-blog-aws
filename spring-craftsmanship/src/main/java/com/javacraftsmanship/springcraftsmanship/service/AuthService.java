package com.javacraftsmanship.springcraftsmanship.service;

import com.javacraftsmanship.springcraftsmanship.dto.request.LoginRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.request.RegisterRequestDto;


public interface AuthService {
    String login(LoginRequestDto loginDto);

    String register(RegisterRequestDto registerDto);
}
