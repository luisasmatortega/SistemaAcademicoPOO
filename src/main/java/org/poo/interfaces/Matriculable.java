package org.poo.interfaces;

import org.poo.modelo.Curso;
import org.poo.modelo.Matricula;
import org.poo.modelo.Nota;

import java.util.List;

public interface Matriculable {
    Matricula matricularse(Curso curso);
    List<Nota> consultarNotas();
}
