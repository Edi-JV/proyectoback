package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Product;

import java.util.Optional;

public interface ProductService {

    public Optional<Product> findById(Long id);

    void deleteById(Long id);

    public Product save(Product product);

    public Iterable<Product> findAll();

}
