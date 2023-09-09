package com.javacraftsmanship.springcraftsmanship.dto.response;
import lombok.Data;

import java.util.List;
@Data
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String description;
    private CategoryResponseDto category;
    private List<CommentResponseDto> comments;
}
