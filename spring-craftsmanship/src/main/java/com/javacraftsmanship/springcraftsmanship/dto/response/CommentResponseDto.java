package com.javacraftsmanship.springcraftsmanship.dto.response;

import com.javacraftsmanship.springcraftsmanship.entity.Post;
import lombok.Data;

@Data
public class CommentResponseDto {
    private Long id;
    private String email;
    private String name;
    private String content;
    //private PostResponseDto post;
}
