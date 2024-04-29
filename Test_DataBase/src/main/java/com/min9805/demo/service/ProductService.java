package com.min9805.demo.service;

import com.min9805.demo.domain.Product;
import com.min9805.demo.domain.ProductRepository;
import com.min9805.demo.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Long userId, String name, String description, int price) {
        return productRepository.save(Product.builder()
                .user(User.builder().id(userId).build())
                .name(name)
                .description(description)
                .price(price)
                .build());
    }
}
