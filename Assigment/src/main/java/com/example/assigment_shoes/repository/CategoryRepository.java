package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
