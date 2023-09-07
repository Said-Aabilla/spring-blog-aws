package com.javacraftsmanship.springcraftsmanship.service.impl;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import com.javacraftsmanship.springcraftsmanship.entity.Post;
import com.javacraftsmanship.springcraftsmanship.exception.ResourceNotFoundException;
import com.javacraftsmanship.springcraftsmanship.mapper.PostMapper;
import com.javacraftsmanship.springcraftsmanship.repository.PostRepository;
import com.javacraftsmanship.springcraftsmanship.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Override
    public PostResponseDto getById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id.toString()));

        return postMapper.toPostResponseDto(post);
    }

    @Override
    public PostResponsePaginatedDto getAll(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> page = postRepository.findAll(pageRequest);

        return postMapper.toPostResponsePaginatedDto(page);
    }

    @Override
    public PostResponseDto create(PostRequestDto postRequestDto) {
        log.info("Calling create method from PostServiceImpl to create a post");
        Post post = postMapper.toPost(postRequestDto);
        log.info("Post created!");
        return postMapper.toPostResponseDto(postRepository.save(post));
    }

    @Override
    public PostResponseDto update(PostRequestDto postRequestDto, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id.toString()));
        Post newPost = postMapper.toPost(postRequestDto);

        newPost.setId(post.getId());

        return postMapper.toPostResponseDto(postRepository.save(newPost));
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
