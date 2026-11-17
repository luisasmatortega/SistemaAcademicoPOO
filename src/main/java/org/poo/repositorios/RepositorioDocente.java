package org.poo.repositorios;

import org.poo.modelo.Docente;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDocente {
    private final List<Docente> lista = new ArrayList<>();

    public void agregar(Docente e) {
        lista.add(e);
    }

    public Docente buscar(int id) {
        return lista.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean eliminar(int id) {
        return lista.removeIf(d -> d.getId() == id);
    }

    public List<Docente> getTodos() {
        return lista;
    }
}
