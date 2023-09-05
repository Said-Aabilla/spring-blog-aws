package com.javacraftsmanship.springcraftsmanship.controller;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.javacraftsmanship.springcraftsmanship.utils.ApiPaths.*;

@RestController
@RequestMapping(API+V1+POSTS)
public interface PostController {
    @PostMapping
    ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto postRequestDto);
}
