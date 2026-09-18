package com.gcu.lab1_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcu.lab1_api.model.Product;

@Repository 
public final class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

    public ProductRepositoryImpl() {
        // Initialize with some sample products
        save(new Product("Product 1", 10.0, "Description 1", 5, null));
        save(new Product("Product 2", 20.0, "Description 2", 10, null));
        save(new Product("Product 3", 30.0, "Description 3", 15, null));
        save(new Product("Product 4", 40.0, "Description 4", 20, null));
        save(new Product("Product 5", 50.0, "Description 5", 25, null));    
        save(new Product("Product 6", 60.0, "Description 6", 30, null));
        save(new Product("Product 7", 70.0, "Description 7", 35, null));
        save(new Product("Product 8", 80.0, "Description 8", 40, null));
        save(new Product("Product 9", 90.0, "Description 9", 45, null));
        save(new Product("Product 10", 100.0, "Description 10", 50, null));
    }

    @Override 
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override 
    public Product save(Product product) {
        if (product.getId() != null) {
            // Update existing product
            Product existingProduct = findById(product.getId());
            if (existingProduct != null) {
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setQuantity(product.getQuantity());
                return existingProduct;
            }
        }

        if(product.getId() == null) {
            product.setId(nextId++);
        }
        products.add(product);
        return product;
    }

    @Override 
    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
