package com.theproeshop.eshop.rest.api.service;

import com.theproeshop.eshop.rest.api.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    List<Product> getProductsByCategoryId(Long categoryId);

    Product getProductById(Long id);

    Product saveProduct(Long categoryId, Product product);

    Product updateProduct(Long categoryId, Long productId, Product updateProduct);

    void deleteProduct(Long categoryId, Long productId);
}

