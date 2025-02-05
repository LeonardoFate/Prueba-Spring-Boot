package com.PRUEBA_PRACTICA.PROYECTO_BACK.repository;

import com.PRUEBA_PRACTICA.PROYECTO_BACK.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByDespachadoFalse();
}