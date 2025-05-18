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

import com.MiTurno.MiTurno.model.Modulo;
import com.MiTurno.MiTurno.service.ModuloService;

@RestController
@RequestMapping("/api/v1/modulo")
public class ModuloController {
    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public ResponseEntity<List<Modulo>> listar() {
        List<Modulo> modulo = moduloService.findAll();
        if (modulo.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(modulo);
    }    

    @GetMapping("/{id}")    
    public ResponseEntity<Modulo> buscarId(@PathVariable Long id) {
        Modulo modulo = moduloService.findById(id);
        if (modulo == null) {
            return ResponseEntity.notFound().build();   
        }
        return ResponseEntity.ok(modulo);
    }

    @PostMapping
    public ResponseEntity<Modulo> guardar(@RequestBody Modulo modulo) {
        Modulo moduloNueva = moduloService.save(modulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(moduloNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulo> actualizar(@PathVariable Long id, @RequestBody Modulo modulo){
        try{
            moduloService.save(modulo);
            return ResponseEntity.ok(modulo);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Modulo> patchModulo(@PathVariable Long id, @RequestBody Modulo partialModulo) {
        try {
            Modulo updatedModulo = moduloService.patchModulo(id, partialModulo);
            return ResponseEntity.ok(updatedModulo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        moduloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
