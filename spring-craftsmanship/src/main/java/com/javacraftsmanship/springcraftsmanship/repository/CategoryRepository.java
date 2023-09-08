package com.javacraftsmanship.springcraftsmanship.repository;

import com.javacraftsmanship.springcraftsmanship.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
