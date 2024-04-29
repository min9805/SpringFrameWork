package com.min9805.demo.service;

import com.min9805.demo.domain.Product;
import com.min9805.demo.domain.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createProduct() {
        // Given
        Long userId = 1L;
        String name = "product";
        String description = "description";
        int price = 1000;

        // When
        Product product = productService.createProduct(userId, name, description, price);

        // Then
        assertThat(product.getName()).isEqualTo(name);
    }
}