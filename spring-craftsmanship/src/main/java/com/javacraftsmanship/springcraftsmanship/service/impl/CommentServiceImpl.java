package com.javacraftsmanship.springcraftsmanship.service.impl;

import com.javacraftsmanship.springcraftsmanship.dto.request.CommentRequestDto;
import com.javacraftsmanship.springcraftsmanship.dto.response.CommentResponseDto;
import com.javacraftsmanship.springcraftsmanship.entity.Comment;
import com.javacraftsmanship.springcraftsmanship.entity.Post;
import com.javacraftsmanship.springcraftsmanship.exception.ResourceNotFoundException;
import com.javacraftsmanship.springcraftsmanship.mapper.CommentMapper;
import com.javacraftsmanship.springcraftsmanship.repository.CommentRepository;
import com.javacraftsmanship.springcraftsmanship.repository.PostRepository;
import com.javacraftsmanship.springcraftsmanship.service.CommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public CommentResponseDto getById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id.toString()));
        return commentMapper.toCommentResponseDto(comment);
    }

    @Override
    public List<CommentResponseDto> getAll(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return commentMapper.toCommentResponseDtoList(comments);
    }


    @Override
    public CommentResponseDto create(Long postId, CommentRequestDto commentRequestDto) {
        Comment comment = commentMapper.toComment(commentRequestDto);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId.toString()));

        comment.setPost(post);

        return commentMapper.toCommentResponseDto(commentRepository.save(comment));
    }

    @Override
    public CommentResponseDto update(CommentRequestDto commentRequestDto, Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id.toString()));

        Comment newComment = commentMapper.toComment(commentRequestDto);

        newComment.setId(comment.getId());
        newComment.setPost(comment.getPost());

        return commentMapper.toCommentResponseDto(commentRepository.save(newComment));
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
