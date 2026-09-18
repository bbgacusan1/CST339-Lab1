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
}