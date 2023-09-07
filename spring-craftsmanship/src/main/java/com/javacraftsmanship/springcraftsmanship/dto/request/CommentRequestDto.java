package com.javacraftsmanship.springcraftsmanship.dto.request;

import lombok.Data;

@Data
public class CommentRequestDto {
    private String email;
    private String name;
    private String content;
}
