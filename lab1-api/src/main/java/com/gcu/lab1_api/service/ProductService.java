package com.gcu.lab1_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.lab1_api.model.Product;
import com.gcu.lab1_api.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
