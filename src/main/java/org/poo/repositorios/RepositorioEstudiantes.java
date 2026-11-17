package org.poo.repositorios;

import org.poo.modelo.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEstudiantes {
    private final List<Estudiante> lista = new ArrayList<>();

    public void agregar(Estudiante e) {
        lista.add(e);
    }

    public Estudiante buscar(String codigo) {
        return lista.stream()
                .filter(e -> e.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminar(String codigo) {
        return lista.removeIf(e -> e.getCodigo().equalsIgnoreCase(codigo));
    }

    public List<Estudiante> getTodos() {
        return lista;
    }
}
