package com.javacraftsmanship.springcraftsmanship.service.impl;

import com.javacraftsmanship.springcraftsmanship.dto.request.LoginRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.request.RegisterRequestDto;
import com.javacraftsmanship.springcraftsmanship.entity.Role;
import com.javacraftsmanship.springcraftsmanship.entity.User;
import com.javacraftsmanship.springcraftsmanship.exception.BlogAPIException;
import com.javacraftsmanship.springcraftsmanship.repository.RoleRepository;
import com.javacraftsmanship.springcraftsmanship.repository.UserRepository;
import com.javacraftsmanship.springcraftsmanship.security.JwtTokenProvider;
import com.javacraftsmanship.springcraftsmanship.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.javacraftsmanship.springcraftsmanship.utils.AppRoles.ROLE_USER;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginRequestDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterRequestDto registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        List<Role> roles = new ArrayList<>();
        Role userRole = roleRepository.findByName(ROLE_USER).get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User registered successfully!";
    }
}
