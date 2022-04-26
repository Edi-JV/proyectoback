package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Encabezado;
import com.grupodinamita.proyecto.entity.Inventario;
import com.grupodinamita.proyecto.repository.EncabezadoRepository;
import com.grupodinamita.proyecto.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EncabezadoServiceImp implements EncabezadoService{

    @Autowired
    private EncabezadoRepository encabezadoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Encabezado> findById(Long id) {
        return encabezadoRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        encabezadoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Encabezado save(Encabezado product) {
        return encabezadoRepository.save(product);
    }

    @Override
    public Iterable<Encabezado> findAll() {
        return encabezadoRepository.findAll();
    }

}
