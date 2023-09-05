package com.javacraftsmanship.springcraftsmanship.mapper;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.entity.Post;
import org.springframework.stereotype.Component;

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
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setDescription(post.getDescription());
        return postResponseDto;
    }
}
