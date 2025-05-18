package com.MiTurno.MiTurno.model;

import java.sql.Time;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="turno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fecha;

    @Column(length = 11, nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private Time hora_creacion;

    @Column(nullable = false)
    private Time hora_atencion;

    @Column(nullable = true)
    private Time hora_cancelacion;

    @ManyToOne
    @JoinColumn(name = "sucursal_id" , nullable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "estado_id" , nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id" , nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "modulo_id" , nullable = false)
    private Modulo modulo;    
}
