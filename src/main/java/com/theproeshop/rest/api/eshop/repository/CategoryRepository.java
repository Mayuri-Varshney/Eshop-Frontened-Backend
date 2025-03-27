package com.theproeshop.rest.api.eshop.repository;

import com.theproeshop.rest.api.eshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
