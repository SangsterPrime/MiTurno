package com.MiTurno.MiTurno.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MiTurno.MiTurno.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>{

    @Query(""" 
        SELECT s, s.configuracion.notificaciones_activadas, s.institucion.nombre FROM Sucursal s        
        """)
    List<Object[]> findSucursalConConfigYInsti();
}
