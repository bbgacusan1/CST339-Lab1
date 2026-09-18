package com.gcu.lab1_api.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gcu.lab1_api.model.Product;
import com.gcu.lab1_api.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGetAllProducts() {
        // Arrange
        Product product1 = new Product("Product 1", 10.0, "Description 1", 5, 1L);
        when(productRepository.findAll()).thenReturn(List.of(product1));

        // Act
        List<Product> result = productService.getAllProducts();

        // Assert
        assertEquals(1, result.size());
        assertEquals("Product 1", result.get(0).getName());
        verify(productRepository).findAll();
    }

    @Test
    void testGetProductById() {
        // Arrange
        Product product = new Product("Product 1", 10.0, "Description 1", 5, 1L);
        when(productRepository.findById(1L)).thenReturn(product);

        // Act
        Product result = productService.getProductById(1L);

        // Assert
        assertEquals("Product 1", result.getName());
        verify(productRepository).findById(1L);
    }

    @Test
    void testCreateProduct() {
        // Arrange
        Product product = new Product("Product 1", 10.0, "Description 1", 5, null);
        when(productRepository.save(product)).thenReturn(product);

        // Act
        Product result = productService.createProduct(product);

        // Assert
        assertEquals("Product 1", result.getName());
        verify(productRepository).save(product);
    }

    @Test
    void testUpdateProduct() {
        // Arrange
        Product existingProduct = new Product("Product 1", 10.0, "Description 1", 5, 1L);
        Product updatedProduct = new Product("Updated Product", 15.0, "Updated Description", 10, null);
        when(productRepository.findById(1L)).thenReturn(existingProduct);
        when(productRepository.save(existingProduct)).thenReturn(existingProduct);

        // Act
        Product result = productService.updateProduct(1L, updatedProduct);

        // Assert
        assertEquals("Updated Product", result.getName());
        assertEquals(15.0, result.getPrice());
        verify(productRepository).findById(1L);
        verify(productRepository).save(existingProduct);
    }

    @Test
    void testDeleteProduct() {
        // Arrange
        Product product = new Product("Product 1", 10.0, "Description 1", 5, 1L);
        when(productRepository.findById(1L)).thenReturn(product);

        // Act
        boolean result = productService.deleteProduct(1L);

        // Assert
        assertEquals(true, result);
        verify(productRepository).findById(1L);
        verify(productRepository).deleteById(1L);
    }
}