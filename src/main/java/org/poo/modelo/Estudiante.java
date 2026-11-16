package org.poo.modelo;

import org.poo.interfaces.Matriculable;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona implements Matriculable {
    private String codigo;
    private List<Matricula> matriculas;
    private List<Pago> pagos;

    public Estudiante(int id, String nombres, String apellidos, String dni, String correo, String contrasena, String codigo) {
        super(id, nombres, apellidos, dni, correo, contrasena);
        this.codigo = codigo;
        this.matriculas = new ArrayList<>();
        this.pagos = new ArrayList<>();
    }

    @Override
    public Matricula matricularse(Curso curso) {
        // Lógica de matrícula
        return null;
    }

    @Override
    public List<Nota> consultarNotas() {
        List<Nota> todasLasNotas = new ArrayList<>();
        for (Matricula m : matriculas) {
            todasLasNotas.addAll(m.getNotas());
        }
        return todasLasNotas;
    }

    public List<Horario> consultarHorarios() {
        List<Horario> horarios = new ArrayList<>();
        for (Matricula m : matriculas) {
            if (m.getCurso() != null) {
                horarios.addAll(m.getCurso().getHorarios());
            }
        }
        return horarios;
    }

    public List<Pago> consultarPagos() { return pagos; }
    public String getCodigo() { return codigo; }

    @Override
    public String getRol() {
        return "ESTUDIANTE";
    }
}
