package com.PRUEBA_PRACTICA.PROYECTO_BACK.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String area;
    private String tramite;
    private String observacion;

    private boolean despachado = false;
    @Column(length = 500)
    private String comentario;

    private String archivo;
}
