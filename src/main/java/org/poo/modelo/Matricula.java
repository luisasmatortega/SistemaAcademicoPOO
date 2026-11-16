package org.poo.modelo;

import org.poo.enums.EstadoMatricula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private int id;
    private LocalDate fecha;
    private EstadoMatricula estado;
    private Estudiante estudiante;
    private Curso curso;
    private PeriodoAcademico periodo;
    private List<Nota> notas;          // Composición
    private List<Asistencia> asistencias; // Composición

    public Matricula(Estudiante estudiante, Curso curso, PeriodoAcademico periodo) {
        this.fecha = LocalDate.now();
        this.estado = EstadoMatricula.REGISTRADA;
        this.estudiante = estudiante;
        this.curso = curso;
        this.periodo = periodo;
        this.notas = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }

    public void validarCumpleRequisitos(boolean cumple) {
        if (!cumple) this.estado = EstadoMatricula.CANCELADA;
    }

    public void activar() { this.estado = EstadoMatricula.ACTIVA; }
    public void cancelar() { this.estado = EstadoMatricula.CANCELADA; }
    public void finalizar() { this.estado = EstadoMatricula.FINALIZADA; }

    public void agregarNota(Nota n) { this.notas.add(n); }
    public void registrarAsistencia(Asistencia a) { this.asistencias.add(a); }

    public double calcularPromedio() {
        double suma = 0;
        for (Nota n : notas) {
            suma += n.getPonderado();
        }
        return suma;
    }

    public List<Nota> getNotas() { return notas; }
    public Curso getCurso() { return curso; }
    public EstadoMatricula getEstado() { return estado; }
}
