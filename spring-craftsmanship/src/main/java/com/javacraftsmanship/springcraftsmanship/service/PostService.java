package com.javacraftsmanship.springcraftsmanship.service;


import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
  PostResponseDto create (PostRequestDto postRequestDto);
  PostResponseDto update (PostRequestDto postRequestDto);
}
