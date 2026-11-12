package org.example.project1.controller;

import org.example.project1.model.Product;
import org.example.project1.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /api/products?name=...
    @GetMapping
    public List<Product> getAll(@RequestParam(required = false) String name) {
        return productService.getAllProducts(name);
    }

    // GET /api/products/{id}
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}