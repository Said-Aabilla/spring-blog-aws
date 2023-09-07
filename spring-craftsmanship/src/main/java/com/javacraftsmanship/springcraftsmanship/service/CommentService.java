package com.javacraftsmanship.springcraftsmanship.service;


import com.javacraftsmanship.springcraftsmanship.dto.request.CommentRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CommentResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;

import java.util.List;


public interface CommentService {
  CommentResponseDto getById (Long id);
  List<CommentResponseDto> getAll (Long postId);
  CommentResponseDto create(Long postId, CommentRequestDto commentRequestDto);

  CommentResponseDto update (CommentRequestDto commentRequestDto, Long id);
  void delete (Long id);
}
