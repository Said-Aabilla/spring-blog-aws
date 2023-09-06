package com.javacraftsmanship.springcraftsmanship.dto.response;

import lombok.Data;

@Data
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String description;
}
