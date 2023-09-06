package com.javacraftsmanship.springcraftsmanship.service;


import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;

import java.util.List;


public interface PostService {
  PostResponseDto getById (Long id);
  List<PostResponseDto> getAll ();
  PostResponseDto create (PostRequestDto postRequestDto);
  PostResponseDto update (PostRequestDto postRequestDto, Long id);
  void delete (Long id);
}
