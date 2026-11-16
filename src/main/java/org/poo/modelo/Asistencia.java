package org.poo.modelo;

import org.poo.enums.EstadoAsistencia;

import java.time.LocalDate;

public class Asistencia {
    private int id;
    private LocalDate fecha;
    private EstadoAsistencia estado;

    public Asistencia(int id, LocalDate fecha, EstadoAsistencia estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
    }

    public EstadoAsistencia getEstado() { return estado; }
}
