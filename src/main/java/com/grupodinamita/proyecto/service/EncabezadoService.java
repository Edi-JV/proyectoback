package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Encabezado;

import java.util.Optional;

public interface EncabezadoService {

    public Optional<Encabezado> findById(Long id);

    void deleteById(Long id);

    public Encabezado save(Encabezado product);

    public Iterable<Encabezado> findAll();

}
