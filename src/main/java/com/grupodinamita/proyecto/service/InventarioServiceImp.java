package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Inventario;
import com.grupodinamita.proyecto.entity.Product;
import com.grupodinamita.proyecto.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InventarioServiceImp implements InventarioService{

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Inventario> findById(Long id) {
        return inventarioRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Inventario save(Inventario product) {
        return inventarioRepository.save(product);
    }

    @Override
    public Iterable<Inventario> findAll() {
        return inventarioRepository.findAll();
    }
}
