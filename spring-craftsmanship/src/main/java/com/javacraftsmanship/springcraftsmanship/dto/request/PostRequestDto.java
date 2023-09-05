package com.javacraftsmanship.springcraftsmanship.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String content;
    private String description;
}
