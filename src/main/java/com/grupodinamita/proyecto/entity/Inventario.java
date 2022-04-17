package com.grupodinamita.proyecto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="inventary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventario implements Serializable {

    private String idproducto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_persona;

    private int cantidad;
}
