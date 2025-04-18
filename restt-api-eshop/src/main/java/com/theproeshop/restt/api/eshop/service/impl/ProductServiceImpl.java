package com.theproeshop.restt.api.eshop.service.impl;

import com.theproeshop.restt.api.eshop.entity.Category;
import com.theproeshop.restt.api.eshop.entity.Product;
import com.theproeshop.restt.api.eshop.exception.EShopException;
import com.theproeshop.restt.api.eshop.exception.ResourceNotFoundException;
import com.theproeshop.restt.api.eshop.repository.CategoryRepository;
import com.theproeshop.restt.api.eshop.repository.ProductRepository;
import com.theproeshop.restt.api.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
        return product;
    }

    @Override
    public Product saveProduct(Long categoryId, Product newProduct) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        newProduct.setCategory(category);
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long categoryId, Long productId, Product updateProduct) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
        if (!product.getCategory().getId().equals(categoryId)) {
            throw new EShopException(HttpStatus.BAD_REQUEST, "Category and product not belong to each other");
        }
        product.setName(updateProduct.getName());
        product.setImage(updateProduct.getImage());
        product.setPrice(updateProduct.getPrice());
        product.setDescription(updateProduct.getDescription());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long categoryId, Long productId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));
        if (!product.getCategory().getId().equals(categoryId)) {
            throw new EShopException(HttpStatus.BAD_REQUEST, "Category and product not belong to each other");
        }
        productRepository.deleteById(productId);
    }
}
