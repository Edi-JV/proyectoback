package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.Detalle;
import com.grupodinamita.proyecto.entity.Inventario;
import com.grupodinamita.proyecto.repository.DetalleRepository;
import com.grupodinamita.proyecto.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DetalleServiceImp implements DetalleService{

    @Autowired
    private DetalleRepository detalleRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Detalle> findById(Long id) {
        return detalleRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        detalleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Detalle save(Detalle detalle) {
        return detalleRepository.save(detalle);
    }

    @Override
    public Iterable<Detalle> findAll() {
        return detalleRepository.findAll();
    }

}
