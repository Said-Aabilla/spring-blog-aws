package com.javacraftsmanship.springcraftsmanship.service;

import com.javacraftsmanship.springcraftsmanship.dto.request.CategoryRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto create(CategoryRequestDto categoryDto);

    CategoryResponseDto getById(Long id);

    List<CategoryResponseDto> getAll ();

    CategoryResponseDto update (CategoryRequestDto categoryDto, Long id);

    void delete (Long id);
}
