package com.grupodinamita.proyecto.repository;

import com.grupodinamita.proyecto.entity.Inventario;
import org.springframework.data.repository.CrudRepository;

public interface InventarioRepository extends CrudRepository<Inventario,Long> {
}
