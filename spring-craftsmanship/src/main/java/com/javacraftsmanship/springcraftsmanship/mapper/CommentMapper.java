package com.javacraftsmanship.springcraftsmanship.mapper;
import com.javacraftsmanship.springcraftsmanship.dto.request.CommentRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CommentResponseDto;
import com.javacraftsmanship.springcraftsmanship.entity.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    public Comment toComment(CommentRequestDto  commentRequestDto){
        Comment comment = new Comment();
        comment.setName(commentRequestDto.getName());
        comment.setEmail(commentRequestDto.getEmail());
        comment.setContent(commentRequestDto.getContent());
        return comment;
    }

    public CommentResponseDto toCommentResponseDto(Comment comment){
        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setId(comment.getId());
        commentResponseDto.setName(comment.getName());
        commentResponseDto.setContent(comment.getContent());
        commentResponseDto.setEmail(comment.getEmail());
        return commentResponseDto;
    }
    public List<CommentResponseDto> toCommentResponseDtoList(List<Comment> comments) {
        return comments.stream().map(this::toCommentResponseDto).collect(Collectors.toList());
    }
}
