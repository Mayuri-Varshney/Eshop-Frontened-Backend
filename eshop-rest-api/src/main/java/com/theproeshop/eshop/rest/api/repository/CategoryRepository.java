package com.theproeshop.eshop.rest.api.repository;

import com.theproeshop.eshop.rest.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
