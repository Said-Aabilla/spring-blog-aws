package com.javacraftsmanship.springcraftsmanship.service.impl;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.entity.Post;
import com.javacraftsmanship.springcraftsmanship.mapper.PostMapper;
import com.javacraftsmanship.springcraftsmanship.repository.PostRepository;
import com.javacraftsmanship.springcraftsmanship.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Override
    public PostResponseDto create(PostRequestDto postRequestDto) {
        log.info("Calling create method from PostServiceImpl to create a post");
        Post post = postMapper.toPost(postRequestDto);
        postRepository.save(post);
        log.info("Post created!");
        return postMapper.toPostResponseDto( post);
    }

    @Override
    public PostResponseDto update(PostRequestDto postRequestDto) {
        return null;
    }
}
