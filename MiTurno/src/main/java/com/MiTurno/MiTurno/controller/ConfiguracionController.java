package com.MiTurno.MiTurno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiTurno.MiTurno.model.Configuracion;
import com.MiTurno.MiTurno.service.ConfiguracionService;

@RestController
@RequestMapping("/api/v1/configuracion")
public class ConfiguracionController {

    @Autowired
    private ConfiguracionService configuracionService;

    @GetMapping
    public ResponseEntity<List<Configuracion>> listar() {
        List<Configuracion> configuracion = configuracionService.findAll();
        if (configuracion.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(configuracion);
    }    

    @GetMapping("/{id}")    
    public ResponseEntity<Configuracion> buscarId(@PathVariable Long id) {
        Configuracion configuracion = configuracionService.findById(id);
        if (configuracion == null) {
            return ResponseEntity.notFound().build();   
        }
        return ResponseEntity.ok(configuracion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Configuracion> actualizar(@PathVariable Long id, @RequestBody Configuracion configuracion){
        try{
            configuracionService.save(configuracion);
            return ResponseEntity.ok(configuracion);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Configuracion> patchConfiguracion(@PathVariable Long id, @RequestBody Configuracion partialConfiguracion) {
        try {
            Configuracion updatedConfiguracion = configuracionService.patchConfiguracion(id, partialConfiguracion);
            return ResponseEntity.ok(updatedConfiguracion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
