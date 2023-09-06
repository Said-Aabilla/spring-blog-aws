package com.javacraftsmanship.springcraftsmanship.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PostResponsePaginatedDto {
    private List<PostResponseDto> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean last;
}
