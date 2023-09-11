package com.javacraftsmanship.springcraftsmanship.controller;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import static com.javacraftsmanship.springcraftsmanship.utils.ApiPaths.*;
import static com.javacraftsmanship.springcraftsmanship.utils.AppConstants.*;

@RestController
@RequestMapping(API + V1 + POSTS)
@Tag(
        name = "CRUD REST APIs for Post Resource"
)
public interface PostController {
    @GetMapping
    PostResponsePaginatedDto getAll(@RequestParam( defaultValue =  DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                    @RequestParam( defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                    @RequestParam( defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
                                    @RequestParam( defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir);

    @GetMapping("/{id}")
    ResponseEntity<PostResponseDto> getById(@PathVariable  Long id);

    @PostMapping
    ResponseEntity<PostResponseDto> create( @RequestBody @Valid PostRequestDto postRequestDto);

    @PutMapping("/{id}")
    ResponseEntity<PostResponseDto> update( @RequestBody @Valid PostRequestDto postRequestDto, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable  Long id);
}
