package com.MiTurno.MiTurno.controller;

import java.util.List;

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

import com.MiTurno.MiTurno.model.Trabajador;
import com.MiTurno.MiTurno.service.TrabajadorService;


@RestController
@RequestMapping("/api/v1/trabajador")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public ResponseEntity<List<Trabajador>> listar() {
        List<Trabajador> trabajador = trabajadorService.findAll();
        if (trabajador.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trabajador);
    }    

    @GetMapping("/{id}")    
    public ResponseEntity<Trabajador> buscarId(@PathVariable Long id) {
        Trabajador trabajador = trabajadorService.findById(id);
        if (trabajador == null) {
            return ResponseEntity.notFound().build();   
        }
        return ResponseEntity.ok(trabajador);
    }

    @PostMapping
    public ResponseEntity<Trabajador> guardar(@RequestBody Trabajador trabajador) {
        Trabajador trabajadorNueva = trabajadorService.save(trabajador);
        return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(@PathVariable Long id, @RequestBody Trabajador trabajador){
        try{
            trabajadorService.save(trabajador);
            return ResponseEntity.ok(trabajador);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Trabajador> patchTrabajador(@PathVariable Long id, @RequestBody Trabajador partialTrabajador) {
        try {
            Trabajador updatedTrabajador = trabajadorService.patchTrabajador(id, partialTrabajador);
            return ResponseEntity.ok(updatedTrabajador);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        trabajadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
