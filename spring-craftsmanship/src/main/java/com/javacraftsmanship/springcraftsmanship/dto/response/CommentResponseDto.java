package com.javacraftsmanship.springcraftsmanship.dto.response;

import lombok.Data;

@Data
public class CommentResponseDto {
    private Long id;
    private String email;
    private String name;
    private String content;
}
