package org.poo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String codigo;
    private String nombre;
    private int creditos;
    private int vacantes;
    private Docente docente;
    private List<Horario> horarios;

    public Curso(String codigo, String nombre, int creditos, int vacantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.vacantes = vacantes;
        this.horarios = new ArrayList<>();
    }

    public boolean hayVacantes() {
        return vacantes > 0;
    }

    public void reservarVacante() {
        if (hayVacantes()) vacantes--;
    }

    public void liberarVacante() {
        vacantes++;
    }

    public void asignarDocente(Docente d) {
        this.docente = d;
    }

    public void agregarHorario(Horario h) {
        this.horarios.add(h);
    }

    public void actualizarCurso(String nombre, int creditos, int vacantes) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.vacantes = vacantes;
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public List<Horario> getHorarios() { return horarios; }

}
