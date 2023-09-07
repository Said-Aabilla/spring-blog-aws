package com.javacraftsmanship.springcraftsmanship.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class PostRequestDto {

    @NotBlank(message = "title should not be blank")
    @Size(min = 2,message ="title should have at least 2 characters")
    private String title;

    @NotBlank(message = "content should not be blank")
    @Size(min = 10,message ="content should have at least 10 characters")
    private String content;

    @NotBlank(message = "description should not be blank")
    @Size(min = 10,message ="description should have at least 10 characters")
    private String description;
}
