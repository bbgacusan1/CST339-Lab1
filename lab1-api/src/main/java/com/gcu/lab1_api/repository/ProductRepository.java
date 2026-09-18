package com.gcu.lab1_api.repository;

import java.util.List;

import com.gcu.lab1_api.model.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    
}
