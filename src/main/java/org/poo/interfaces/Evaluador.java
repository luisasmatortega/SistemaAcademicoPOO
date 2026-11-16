package org.poo.interfaces;

import org.poo.modelo.Curso;

public interface Evaluador {
    void registrarNotas(Curso curso);
    void registrarAsistencia(Curso curso);
}
