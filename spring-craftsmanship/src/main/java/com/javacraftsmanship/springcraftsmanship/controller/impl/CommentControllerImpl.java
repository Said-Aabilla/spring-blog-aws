package com.javacraftsmanship.springcraftsmanship.controller.impl;

import com.javacraftsmanship.springcraftsmanship.controller.CommentController;
import com.javacraftsmanship.springcraftsmanship.controller.PostController;
import com.javacraftsmanship.springcraftsmanship.dto.request.CommentRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CommentResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import com.javacraftsmanship.springcraftsmanship.service.CommentService;
import com.javacraftsmanship.springcraftsmanship.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController {


    private final CommentService commentService ;

    @Override
    public List<CommentResponseDto> getAll( Long postId) {
        return commentService.getAll(postId);
    }

    @Override
    public ResponseEntity<CommentResponseDto> getById(Long id) {
        return ResponseEntity.ok(commentService.getById(id));
    }

    @Override
    public ResponseEntity<CommentResponseDto> create(Long postId, CommentRequestDto commentRequestDto) {
        return new ResponseEntity<>(commentService.create(postId,commentRequestDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CommentResponseDto> update(CommentRequestDto commentRequestDto, Long id) {
        return new ResponseEntity<>(commentService.update(commentRequestDto,id), HttpStatus.ACCEPTED) ;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        commentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
