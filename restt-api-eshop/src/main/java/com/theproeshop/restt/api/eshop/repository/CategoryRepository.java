package com.theproeshop.restt.api.eshop.repository;

import com.theproeshop.restt.api.eshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
