package com.javacraftsmanship.springcraftsmanship.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentRequestDto {

    @NotBlank(message = "email should not be null or blank")
    @Email
    private String email;

    @NotBlank(message = "name should not be null or blank")
    private String name;

    @NotBlank(message = "content should not be null or blank")
    @Size(min = 10,message ="content should have at least 10 characters")
    private String content;
}
