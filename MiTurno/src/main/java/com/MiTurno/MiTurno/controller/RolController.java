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

import com.MiTurno.MiTurno.model.Rol;
import com.MiTurno.MiTurno.service.RolService;



@RestController
@RequestMapping("/api/v1/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> listar() {
        List<Rol> rol = rolService.findAll();
        if (rol.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rol);
    }    

    @GetMapping("/{id}")    
    public ResponseEntity<Rol> buscarId(@PathVariable Long id) {
        Rol rol = rolService.findById(id);
        if (rol == null) {
            return ResponseEntity.notFound().build();   
        }
        return ResponseEntity.ok(rol);
    }

    @PostMapping
    public ResponseEntity<Rol> guardar(@RequestBody Rol rol) {
        Rol rolNueva = rolService.save(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(rolNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizar(@PathVariable Long id, @RequestBody Rol rol){
        try{
            rolService.save(rol);
            return ResponseEntity.ok(rol);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Rol> patchRol(@PathVariable Long id, @RequestBody Rol partialRol) {
        try {
            Rol updatedRol = rolService.patchRol(id, partialRol);
            return ResponseEntity.ok(updatedRol);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
