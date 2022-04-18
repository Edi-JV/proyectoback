package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.User;
import com.grupodinamita.proyecto.entity.subclases.Category;
import com.grupodinamita.proyecto.repository.CategoryRepository;
import com.grupodinamita.proyecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {categoryRepository.deleteById(id);}

    @Override
    @Transactional
    public Category save(Category user) {return categoryRepository.save(user);}

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

}
