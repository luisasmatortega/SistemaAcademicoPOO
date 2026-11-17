package org.poo.repositorios;

import org.poo.modelo.Curso;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCursos {
    private final List<Curso> lista = new ArrayList<>();

    public void agregar(Curso c) {
        lista.add(c);
    }

    public Curso buscar(String codigo) {
        return lista.stream()
                .filter(c -> c.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminar(String codigo) {
        return lista.removeIf(c -> c.getCodigo().equalsIgnoreCase(codigo));
    }

    public List<Curso> getTodos() {
        return lista;
    }
}
