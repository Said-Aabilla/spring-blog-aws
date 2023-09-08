package com.javacraftsmanship.springcraftsmanship.mapper;
import com.javacraftsmanship.springcraftsmanship.dto.request.CategoryRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CategoryResponseDto;
import com.javacraftsmanship.springcraftsmanship.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category toCategory(CategoryRequestDto categoryRequestDto){
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        return category;
    }

    public CategoryResponseDto toCategoryResponseDto( Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        categoryResponseDto.setDescription(category.getDescription());
        return categoryResponseDto;
    }
    public List<CategoryResponseDto> tocategoryResponseDtoList(List< Category > categories) {
        return categories.stream().map(this::toCategoryResponseDto).collect(Collectors.toList());
    }
}
