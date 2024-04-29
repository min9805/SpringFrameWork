package com.min9805.demo.service;

import com.min9805.demo.domain.Product;
import com.min9805.demo.domain.ProductRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"/user.sql"})
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    @Sql(scripts = {"/product.sql"})
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

    @Test
    void createProduct2() {
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