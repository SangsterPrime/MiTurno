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

import com.MiTurno.MiTurno.model.Sucursal;
import com.MiTurno.MiTurno.service.SucursalService;



@RestController
@RequestMapping("/api/v1/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> listar() {
        List<Sucursal> sucursal = sucursalService.findAll();
        if (sucursal.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sucursal);
    }    

    @GetMapping("/{id}")    
    public ResponseEntity<Sucursal> buscarId(@PathVariable Long id) {
        Sucursal sucursal = sucursalService.findById(id);
        if (sucursal == null) {
            return ResponseEntity.notFound().build();   
        }
        return ResponseEntity.ok(sucursal);
    }

    @GetMapping("/{capacidad}")    
    public ResponseEntity<Sucursal> buscarCapacidad(@PathVariable Integer capacidad_maxima) {
        Sucursal sucursal = sucursalService.findByCapacidad(capacidad_maxima);
        if (sucursal == null) {
            return ResponseEntity.notFound().build();   
        }
        return ResponseEntity.ok(sucursal);
    }

    @GetMapping("/resumen")
    public ResponseEntity<List<Map<String, Object>>> resumen() {
        List<Map<String, Object>> resumen = sucursalService.obtenerSucursalConConfigYInsti();
        if (resumen.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resumen);
    }

    @PostMapping
    public ResponseEntity<Sucursal> guardar(@RequestBody Sucursal sucursal) {
        Sucursal sucursalNueva = sucursalService.save(sucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizar(@PathVariable Long id, @RequestBody Sucursal sucursal){
        try{
            sucursalService.save(sucursal);
            return ResponseEntity.ok(sucursal);
        }catch( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Sucursal> patchSucursal(@PathVariable Long id, @RequestBody Sucursal partialSucursal) {
        try {
            Sucursal updatedSucursal = sucursalService.patchSucursal(id, partialSucursal);
            return ResponseEntity.ok(updatedSucursal);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        sucursalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
