package org.poo.modelo;

import org.poo.interfaces.Evaluador;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Persona implements Evaluador {
    private String especialidad;
    private List<Curso> cursos;

    public Docente(int id, String nombres, String apellidos, String dni, String correo, String contrasena, String especialidad) {
        super(id, nombres, apellidos, dni, correo, contrasena);
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    @Override
    public void registrarNotas(Curso curso) {
        System.out.println("Registrando notas para el curso: " + curso.getNombre());
    }

    @Override
    public void registrarAsistencia(Curso curso) {
        System.out.println("Registrando asistencia para el curso: " + curso.getNombre());
    }

    public List<Curso> getCursosAsignados() {
        return cursos;
    }

    @Override
    public String getRol() {
        return "DOCENTE";
    }

    public void setEspecialidad(String nuevaEspecialidad){
        this.especialidad = nuevaEspecialidad;
    }
}
