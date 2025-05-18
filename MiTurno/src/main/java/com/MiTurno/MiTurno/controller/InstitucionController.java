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

import com.MiTurno.MiTurno.model.Institucion;
import com.MiTurno.MiTurno.service.InstitucionService;

@RestController
@RequestMapping("/api/v1/institucion")
public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @GetMapping
    public ResponseEntity<List<Institucion>> listar() {
        List<Institucion> institucion = institucionService.findAll();
        if (institucion.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(institucion);
    }    

    @GetMapping("/{id}")    
    public ResponseEntity<Institucion> buscarId(@PathVariable Long id) {
        Institucion institucion = institucionService.findById(id);
        if (institucion == null) {
            return ResponseEntity.notFound().build();   
        }
        return ResponseEntity.ok(institucion);
    }

    @PostMapping
    public ResponseEntity<Institucion> guardar(@RequestBody Institucion institucion) {
        Institucion institucionNueva = institucionService.save(institucion);
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institucion> actualizar(@PathVariable Long id, @RequestBody Institucion institucion){
        try{
            institucionService.save(institucion);
            return ResponseEntity.ok(institucion);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Institucion> patchInstitucion(@PathVariable Long id, @RequestBody Institucion partialInstitucion) {
        try {
            Institucion updatedInstitucion = institucionService.patchInstitucion(id, partialInstitucion);
            return ResponseEntity.ok(updatedInstitucion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        institucionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
