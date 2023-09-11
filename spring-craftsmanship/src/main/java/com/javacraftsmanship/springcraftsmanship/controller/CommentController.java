package com.javacraftsmanship.springcraftsmanship.controller;

import com.javacraftsmanship.springcraftsmanship.dto.request.CommentRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CommentResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.javacraftsmanship.springcraftsmanship.utils.ApiPaths.*;
import static com.javacraftsmanship.springcraftsmanship.utils.AppConstants.*;

@RestController
@RequestMapping(API + V1 + POSTS + POST_ID + COMMENTS)
@Tag(
        name = "CRUD REST APIs for Comment Resource"
)
public interface CommentController {
    @GetMapping
    List<CommentResponseDto> getAll(@PathVariable Long postId);

    @GetMapping("/{id}")
    ResponseEntity<CommentResponseDto> getById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<CommentResponseDto> create(@PathVariable Long postId, @Valid @RequestBody CommentRequestDto commentRequestDto);

    @PutMapping("/{id}")
    ResponseEntity<CommentResponseDto> update(@Valid @RequestBody CommentRequestDto commentRequestDto, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
