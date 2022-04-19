package com.grupodinamita.proyecto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Detalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre_categoria;

    private int cantidad;

    private double preciounitario;

    private double subtotal;

    private double total;


}
