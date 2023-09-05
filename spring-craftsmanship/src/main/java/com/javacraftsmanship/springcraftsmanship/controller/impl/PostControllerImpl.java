package com.javacraftsmanship.springcraftsmanship.controller.impl;

import com.javacraftsmanship.springcraftsmanship.controller.PostController;
import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.javacraftsmanship.springcraftsmanship.utils.ApiPaths.*;

@RequestMapping(API+V1+POSTS)
@Slf4j
@RequiredArgsConstructor
public class PostControllerImpl implements PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto postRequestDto){
        log.info("Calling create method from PostControllerImpl to create a post");
        return new ResponseEntity<>(postService.create(postRequestDto), HttpStatus.CREATED) ;
    }
}
