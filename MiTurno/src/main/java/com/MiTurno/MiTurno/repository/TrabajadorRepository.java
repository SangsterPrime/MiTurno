package com.MiTurno.MiTurno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MiTurno.MiTurno.model.Trabajador;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long>{

}
