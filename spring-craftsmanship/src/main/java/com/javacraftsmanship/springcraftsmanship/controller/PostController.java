package com.javacraftsmanship.springcraftsmanship.controller;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.javacraftsmanship.springcraftsmanship.utils.ApiPaths.*;
import static com.javacraftsmanship.springcraftsmanship.utils.AppConstants.*;

@RestController
@RequestMapping(API + V1 + POSTS)
public interface PostController {
    @GetMapping
    PostResponsePaginatedDto getAll(@RequestParam( defaultValue =  DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                    @RequestParam( defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                    @RequestParam( defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
                                    @RequestParam( defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir);

    @GetMapping("/{id}")
    ResponseEntity<PostResponseDto> getById(@PathVariable  Long id);

    @PostMapping
    ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto postRequestDto);

    @PutMapping("/{id}")
    ResponseEntity<PostResponseDto> update(@RequestBody PostRequestDto postRequestDto, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable  Long id);
}
