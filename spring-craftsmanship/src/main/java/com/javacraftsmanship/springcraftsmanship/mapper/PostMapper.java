package com.javacraftsmanship.springcraftsmanship.mapper;

import com.javacraftsmanship.springcraftsmanship.dto.request.PostRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CommentResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponseDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.PostResponsePaginatedDto;
import com.javacraftsmanship.springcraftsmanship.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PostMapper {


    private final CommentMapper commentMapper;
    private final CategoryMapper categoryMapper;

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
        postResponseDto.setCategory(categoryMapper.toCategoryResponseDto(post.getCategory()));

        List<CommentResponseDto> comments = commentMapper.toCommentResponseDtoList(post.getComments());
        postResponseDto.setComments(comments);

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
