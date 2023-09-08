package com.javacraftsmanship.springcraftsmanship.service.impl;

import com.javacraftsmanship.springcraftsmanship.dto.request.CategoryRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CategoryResponseDto;
import com.javacraftsmanship.springcraftsmanship.entity.Category;
import com.javacraftsmanship.springcraftsmanship.exception.ResourceNotFoundException;
import com.javacraftsmanship.springcraftsmanship.mapper.CategoryMapper;
import com.javacraftsmanship.springcraftsmanship.repository.CategoryRepository;
import com.javacraftsmanship.springcraftsmanship.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;


    @Override
    public CategoryResponseDto create(CategoryRequestDto categoryDto) {
        Category category = categoryMapper.toCategory(categoryDto) ;
        return categoryMapper.toCategoryResponseDto( categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDto getById(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId.toString()));

        return categoryMapper.toCategoryResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getAll () {

        List<Category> categories = categoryRepository.findAll();

        return categoryMapper.tocategoryResponseDtoList(categories);
    }

    @Override
    public CategoryResponseDto update(CategoryRequestDto categoryDto, Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId.toString()));

        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setId(categoryId);

        return categoryMapper.toCategoryResponseDto(categoryRepository.save(category));
    }

    @Override
    public void delete (Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId.toString()));

        categoryRepository.delete(category);
    }
}
