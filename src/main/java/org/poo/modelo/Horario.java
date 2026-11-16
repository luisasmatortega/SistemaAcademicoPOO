package org.poo.modelo;

import org.poo.enums.DiaSemana;

import java.time.LocalTime;

public class Horario {
    private int id;
    private DiaSemana dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String aula;

    public Horario(int id, DiaSemana dia, LocalTime horaInicio, LocalTime horaFin, String aula) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aula = aula;
    }

    public boolean seCruzaCon(Horario otro) {
        if (this.dia != otro.dia) return false;
        return this.horaInicio.isBefore(otro.horaFin) && otro.horaInicio.isBefore(this.horaFin);
    }
}
