package com.javacraftsmanship.springcraftsmanship.mapper;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import com.javacraftsmanship.springcraftsmanship.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public Post toPost(PostRequestDto postRequestDto){
        Post post = new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        post.setDescription(postRequestDto.getDescription());
        return post;
    }

    public PostResponseDto toPostResponseDto(Post post){
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(post.getId());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setDescription(post.getDescription());
        return postResponseDto;
    }

    public PostResponsePaginatedDto toPostResponsePaginatedDto(Page<Post> page){
        PostResponsePaginatedDto postResponsePaginatedDto = new PostResponsePaginatedDto();
        postResponsePaginatedDto.setContent(toPostResponseDtoList(page.getContent()));
        postResponsePaginatedDto.setPageNo(page.getNumber());
        postResponsePaginatedDto.setPageSize(page.getSize());
        postResponsePaginatedDto.setTotalPages(page.getTotalPages());
        postResponsePaginatedDto.setTotalElements(page.getTotalElements());
        return postResponsePaginatedDto;
    }
    public List<PostResponseDto> toPostResponseDtoList(List<Post> postList) {
        return postList.stream().map(this::toPostResponseDto).collect(Collectors.toList());
    }

}
