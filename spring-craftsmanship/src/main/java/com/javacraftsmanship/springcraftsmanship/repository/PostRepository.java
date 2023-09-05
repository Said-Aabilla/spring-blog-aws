package com.javacraftsmanship.springcraftsmanship.repository;

import com.javacraftsmanship.springcraftsmanship.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
