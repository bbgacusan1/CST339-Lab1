package com.gcu.lab1_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.lab1_api.dto.ProductDTO;
import com.gcu.lab1_api.model.Product;
import com.gcu.lab1_api.service.ProductService;



@RestController 
public class ProductController {
    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);



    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        logger.info("Fetching all products");
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> dtos = products.stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        logger.info("Fetching product with ID: {}", id);
        Product product = productService.getProductById(id);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }
        ProductDTO dto = toDTO(product);
        return ResponseEntity.ok(dto);
    }
    
    @PostMapping ("/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) {
        logger.info("Creating new product: {}", dto);
        Product created = productService.createProduct(toModel(dto));
        return ResponseEntity.status(201).body(toDTO(created));
    }
    
    
    @PutMapping ("/products/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO dto) {
        logger.info("Updating product with ID: {}", id);
        Product updated = productService.updateProduct(id, toModel(dto));
        if(updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDTO(updated));
    }

    @DeleteMapping ("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        logger.info("Deleting product with ID: {}", id);
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getName(), product.getPrice(), product.getDescription(), product.getQuantity(), product.getId());
    }

    private Product toModel(ProductDTO dto) {
        return new Product(dto.name(), dto.price(), dto.description(), dto.quantity(), dto.id());
    }
}
    
