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

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id);
        if (existingProduct != null) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
