package com.javacraftsmanship.springcraftsmanship.controller;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.javacraftsmanship.springcraftsmanship.utils.ApiPaths.*;

@RestController
@RequestMapping(API+V1+POSTS)
public interface PostController {
    @GetMapping
    List<PostResponseDto> getAll();
    @GetMapping("/{id}")
    ResponseEntity<PostResponseDto> getById (@PathVariable("id") Long id);
    @PostMapping
    ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto postRequestDto);
    @PutMapping("/{id}")
    ResponseEntity<PostResponseDto> update (@RequestBody PostRequestDto postRequestDto,@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete (@PathVariable("id") Long id);
}
