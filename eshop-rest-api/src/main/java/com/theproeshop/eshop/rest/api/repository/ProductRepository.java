package com.theproeshop.eshop.rest.api.repository;

import com.theproeshop.eshop.rest.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
}
