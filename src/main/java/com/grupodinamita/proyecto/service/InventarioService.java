package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Inventario;
import com.grupodinamita.proyecto.entity.Product;

import java.util.Optional;

public interface InventarioService {

    public Optional<Inventario> findById(Long id);

    void deleteById(Long id);

    public Inventario save(Inventario product);

    public Iterable<Inventario> findAll();



}
