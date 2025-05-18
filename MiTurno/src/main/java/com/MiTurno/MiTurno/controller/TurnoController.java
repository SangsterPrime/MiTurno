package com.MiTurno.MiTurno.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiTurno.MiTurno.model.Turno;
import com.MiTurno.MiTurno.service.TurnoService;



@RestController
@RequestMapping("/api/v1/turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public ResponseEntity<List<Turno>> listar() {
        List<Turno> turno = turnoService.findAll();
        if (turno.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(turno);
    }  

    @GetMapping("/{id}")    
    public ResponseEntity<Turno> buscarId(@PathVariable Long id) {
        Turno turno = turnoService.findById(id);
        if (turno == null) {
            return ResponseEntity.notFound().build();   
        }
        return ResponseEntity.ok(turno);
    }

    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {
        Turno turnoNueva = turnoService.save(turno);
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> actualizar(@PathVariable Long id, @RequestBody Turno turno){
        try{
            turnoService.save(turno);
            return ResponseEntity.ok(turno);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Turno> patchTurno(@PathVariable Long id, @RequestBody Turno partialTurno) {
        try {
            Turno updatedTurno = turnoService.patchTurno(id, partialTurno);
            return ResponseEntity.ok(updatedTurno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        turnoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/resumenTurno")
    public ResponseEntity<List<Map<String, Object>>> resumen() {
        List<Map<String, Object>> resumen = turnoService.obtenerTurnosConIdyNombre();
        if (resumen.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resumen);
    }


}
