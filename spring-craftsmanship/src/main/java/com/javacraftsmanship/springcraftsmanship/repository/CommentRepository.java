package com.javacraftsmanship.springcraftsmanship.repository;

import com.javacraftsmanship.springcraftsmanship.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByPostId(Long id);
}
