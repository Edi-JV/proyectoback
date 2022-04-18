package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Product;
import com.grupodinamita.proyecto.entity.subclases.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CategoryService {
    public Optional<Category> findById(Long id);

    void deleteById(Long id);

    public Category save(Category product);

    public Iterable<Category> findAll();
}
