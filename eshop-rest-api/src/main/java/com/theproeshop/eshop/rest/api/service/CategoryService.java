package com.theproeshop.eshop.rest.api.service;

import com.theproeshop.eshop.rest.api.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category newCategory);
    Category updateCategory(Long id, Category updateCategory);
    void deleteCategory(Long id);
}
