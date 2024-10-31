package com.PRUEBA_PRACTICA.PROYECTO_BACK.service;

import com.PRUEBA_PRACTICA.PROYECTO_BACK.entity.Turno;
import com.PRUEBA_PRACTICA.PROYECTO_BACK.exception.ResourceNotFoundException;
import com.PRUEBA_PRACTICA.PROYECTO_BACK.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public Turno crearTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public List<Turno> obtenerTurnos() {
        return turnoRepository.findAll();
    }
    public Turno despacharTurno(Long id, Turno turnoActualizado) {
        Turno turno = turnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado"));

        // Actualizar campos
        turno.setDespachado(true);
        turno.setComentario(turnoActualizado.getComentario());
        turno.setArchivo(turnoActualizado.getArchivo());

        return turnoRepository.save(turno);
    }



    // Método para obtener solo los turnos no despachados
    public List<Turno> obtenerTurnosNoDespachados() {
        return turnoRepository.findByDespachadoFalse();
    }

}