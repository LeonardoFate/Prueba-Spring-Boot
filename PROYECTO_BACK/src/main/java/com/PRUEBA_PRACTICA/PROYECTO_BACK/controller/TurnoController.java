package com.PRUEBA_PRACTICA.PROYECTO_BACK.controller;

import com.PRUEBA_PRACTICA.PROYECTO_BACK.entity.Turno;
import com.PRUEBA_PRACTICA.PROYECTO_BACK.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping("/crear")
    public Turno crearTurno(@RequestBody Turno turno) {
        return turnoService.crearTurno(turno);
    }

    @GetMapping
    public List<Turno> obtenerTurnos() {
        return turnoService.obtenerTurnos();
    }

    @PutMapping("/despachar/{id}")
    public ResponseEntity<Turno> despacharTurno(
            @PathVariable Long id,
            @RequestBody Turno turnoActualizado) {
        Turno turnoDespachado = turnoService.despacharTurno(id, turnoActualizado);
        return ResponseEntity.ok(turnoDespachado);
    }




    @GetMapping("/no-despachados")
    public ResponseEntity<List<Turno>> obtenerTurnosNoDespachados() {
        List<Turno> turnos = turnoService.obtenerTurnosNoDespachados(); // Obtiene solo turnos no despachados
        return ResponseEntity.ok(turnos);
    }
}