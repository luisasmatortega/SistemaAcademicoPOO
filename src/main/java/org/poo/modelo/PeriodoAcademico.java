package org.poo.modelo;

import java.time.LocalDate;

public class PeriodoAcademico {
    private int id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public PeriodoAcademico(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean estaVigente() {
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fechaInicio) && !hoy.isAfter(fechaFin);
    }
}
