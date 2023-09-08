package com.javacraftsmanship.springcraftsmanship.controller.impl;

import com.javacraftsmanship.springcraftsmanship.controller.CategoryController;
import com.javacraftsmanship.springcraftsmanship.dto.request.CategoryRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CategoryResponseDto;
import com.javacraftsmanship.springcraftsmanship.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryControllerImpl implements CategoryController {

    private CategoryService categoryService;


    // Build Add Category REST API
    @Override
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto categoryDto){
        CategoryResponseDto savedCategory = categoryService.create(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    // Build Get Category REST API
    @Override
    public ResponseEntity<CategoryResponseDto> getById( Long id){
        CategoryResponseDto categoryDto = categoryService.getById(id);
         return ResponseEntity.ok(categoryDto);
    }

    // Build Get All Categories REST API
    @Override
    public ResponseEntity<List<CategoryResponseDto>> getAll(){
        return ResponseEntity.ok(categoryService.getAll ());
    }

    // Build Update Category REST API
    @Override
    public ResponseEntity<CategoryResponseDto> update( CategoryRequestDto categoryDto,
                                                    Long id){
        return ResponseEntity.ok(categoryService.update (categoryDto, id));
    }

    // Build Delete Category REST API
    @Override
    public ResponseEntity<Void> delete(Long id) {
        categoryService.delete (id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
