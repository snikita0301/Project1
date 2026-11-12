package org.example.project1.service;

import org.example.project1.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts(String nameFilter);
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}