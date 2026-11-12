package org.example.project1.repository;

import org.example.project1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Требование из ТЗ: фильтрация по имени
    List<Product> findByNameContainingIgnoreCase(String name);
}