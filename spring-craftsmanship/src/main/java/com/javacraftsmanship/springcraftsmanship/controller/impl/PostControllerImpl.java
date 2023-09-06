package com.javacraftsmanship.springcraftsmanship.controller.impl;

import com.javacraftsmanship.springcraftsmanship.controller.PostController;
import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import com.javacraftsmanship.springcraftsmanship.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
public class PostControllerImpl implements PostController {

    private final PostService postService;

    @Override
    public PostResponsePaginatedDto getAll(int pageNo, int pageSize,String sortBy,String sortDir) {
        return postService.getAll(pageNo,pageSize,sortBy,sortDir );
    }

    @Override
    public ResponseEntity<PostResponseDto> getById(Long id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @Override
    public ResponseEntity<PostResponseDto> create(PostRequestDto postRequestDto) {
        log.info("Calling create method from PostControllerImpl to create a post");
        return new ResponseEntity<>(postService.create(postRequestDto), HttpStatus.CREATED) ;
    }

    @Override
    public ResponseEntity<PostResponseDto> update(PostRequestDto postRequestDto, Long id) {
        return new ResponseEntity<>(postService.update(postRequestDto,id), HttpStatus.ACCEPTED) ;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        postService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
