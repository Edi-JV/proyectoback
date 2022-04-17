package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Product;
import com.grupodinamita.proyecto.entity.User;
import com.grupodinamita.proyecto.repository.ProductRepository;
import com.grupodinamita.proyecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
