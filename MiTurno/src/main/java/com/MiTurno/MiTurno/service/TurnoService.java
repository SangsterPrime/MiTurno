package com.MiTurno.MiTurno.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiTurno.MiTurno.model.Turno;
import com.MiTurno.MiTurno.repository.TurnoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public List<Turno> findAll(){
        return turnoRepository.findAll();
    }

    public Turno findById(Long id) {
        return turnoRepository.findById(id).orElse( null);
    }
    
    public void delete(Long id){
        turnoRepository.deleteById(id);
    }

    public Turno save(Turno institucion) {
        return turnoRepository.save(institucion);
    } 

    public Turno patchTurno(Long id, Turno parcialTurno){
        Optional<Turno> turnoOptional = turnoRepository.findById(id);
        if (turnoOptional.isPresent()) {
            
            Turno turnoToUpdate = turnoOptional.get();
            
            if (parcialTurno.getFecha() != null) {
                turnoToUpdate.setFecha(parcialTurno.getFecha());   
            }
            if(parcialTurno.getNumero() != null) {
                turnoToUpdate.setNumero((parcialTurno.getNumero()));
            }
            if (parcialTurno.getHora_creacion() != null) {
                turnoToUpdate.setHora_creacion(parcialTurno.getHora_creacion());   
            }
            if(parcialTurno.getHora_atencion() != null) {
                turnoToUpdate.setHora_atencion((parcialTurno.getHora_atencion()));
            }
            if (parcialTurno.getHora_cancelacion() != null) {
                turnoToUpdate.setHora_cancelacion(parcialTurno.getHora_cancelacion());   
            }
            return turnoRepository.save(turnoToUpdate);
        } else {
            return null; 
        }
    }

    public List<Map<String, Object>> obtenerTurnosConIdyNombre() {
        List<Object[]> resultados = turnoRepository.findTurnoConSucursalYUsuario();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("turno", fila[0]);
            datos.put("idSucursal", fila[1]);
            datos.put("direccion", fila[2]);
            datos.put("nombreUsuario", fila[3]);
            datos.put("apellidoUsuario", fila[4]);
            lista.add(datos);
        }

        return lista;
    }
}
