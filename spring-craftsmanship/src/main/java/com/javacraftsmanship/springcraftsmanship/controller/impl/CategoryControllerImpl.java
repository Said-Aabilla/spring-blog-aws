package com.javacraftsmanship.springcraftsmanship.controller.impl;

import com.javacraftsmanship.springcraftsmanship.controller.CategoryController;
import com.javacraftsmanship.springcraftsmanship.dto.request.CategoryRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CategoryResponseDto;
import com.javacraftsmanship.springcraftsmanship.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.javacraftsmanship.springcraftsmanship.utils.AppRoles.ROLE_ADMIN;

@RestController
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for Category Resource"
)
public class CategoryControllerImpl implements CategoryController {

    private CategoryService categoryService;


    @Operation(
            summary = "Create Category REST API",
            description = "Create Category REST API is used to save post into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // create blog post rest api
    @PreAuthorize("hasRole('"+ROLE_ADMIN+"')")
    // Build Add Category REST API
    @Override
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto categoryDto){
        CategoryResponseDto savedCategory = categoryService.create(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Category By Id REST API",
            description = "Get  Category By Id REST API is used to fetch all the posts from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    // Build Get Category REST API
    @Override
    public ResponseEntity<CategoryResponseDto> getById( Long id){
        CategoryResponseDto categoryDto = categoryService.getById(id);
         return ResponseEntity.ok(categoryDto);
    }

    @Operation(
            summary = "Get All Categories REST API",
            description = "Get All Categories REST API is used to fetch all the posts from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    // Build Get All Categories REST API
    @Override
    public ResponseEntity<List<CategoryResponseDto>> getAll(){
        return ResponseEntity.ok(categoryService.getAll ());
    }

    @Operation(
            summary = "Update Category REST API",
            description = "Update Category REST API is used to fetch all the posts from the database"
    )
    @ApiResponse(
            responseCode = "202",
            description = "Http Status 202 SUCCESS"
    )
    @PreAuthorize("hasRole('"+ROLE_ADMIN+"')")
    // Build Update Category REST API
    @Override
    public ResponseEntity<CategoryResponseDto> update( CategoryRequestDto categoryDto,
                                                    Long id){
        return new ResponseEntity<>(categoryService.update(categoryDto,id), HttpStatus.ACCEPTED) ;
    }

    @Operation(
            summary = "Delete Category REST API",
            description = "Update Category REST API is used to fetch all the posts from the database"
    )
    @ApiResponse(
            responseCode = "204",
            description = "Http Status 204 SUCCESS"
    )
    @PreAuthorize("hasRole('"+ROLE_ADMIN+"')")
    // Build Delete Category REST API
    @Override
    public ResponseEntity<Void> delete(Long id) {
        categoryService.delete (id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
