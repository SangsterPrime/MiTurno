package com.MiTurno.MiTurno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MiTurno.MiTurno.model.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long>{

    @Query(""" 
        SELECT t, t.sucursal.id, t.sucursal.direccion, t.usuario.nombre , t.usuario.apellido FROM Turno t
        """)
    List<Object[]> findTurnoConSucursalYUsuario();

}
