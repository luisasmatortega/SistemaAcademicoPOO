package org.poo.repositorios;

import org.poo.modelo.Matricula;

import java.util.ArrayList;
import java.util.List;

public class RepositorioMatriculas {
    private final List<Matricula> lista = new ArrayList<>();

    public void agregar(Matricula m) {
        lista.add(m);
    }

    public List<Matricula> getTodos() {
        return lista;
    }
}
