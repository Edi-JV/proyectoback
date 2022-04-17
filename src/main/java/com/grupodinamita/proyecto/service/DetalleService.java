package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Detalle;
import com.grupodinamita.proyecto.entity.Product;
import com.grupodinamita.proyecto.entity.subclases.Category;

import java.util.Optional;

public interface DetalleService {
    public Optional<Detalle> findById(Long id);

    void deleteById(Long id);

    public Detalle save(Detalle product);

    public Iterable<Detalle> findAll();
}
