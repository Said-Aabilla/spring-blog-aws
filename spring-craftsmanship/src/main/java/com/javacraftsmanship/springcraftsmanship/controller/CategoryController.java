package com.javacraftsmanship.springcraftsmanship.controller;

import com.javacraftsmanship.springcraftsmanship.dto.request.CategoryRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CategoryResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.javacraftsmanship.springcraftsmanship.utils.ApiPaths.*;

@RestController
@RequestMapping(API+V1+CATEGORIES)
public interface CategoryController {

    @PostMapping
     ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto categoryRequestDto);

    @GetMapping(ID)
     ResponseEntity<CategoryResponseDto> getById(@PathVariable("id") Long categoryId);

    @GetMapping
     ResponseEntity<List<CategoryResponseDto>> getAll();
    @PutMapping(ID)
     ResponseEntity<CategoryResponseDto> update(@RequestBody CategoryRequestDto categoryRequestDto,
                                                      @PathVariable() Long id);

    @DeleteMapping(ID)
    ResponseEntity<Void> delete (@PathVariable() Long id);
}
