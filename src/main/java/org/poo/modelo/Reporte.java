package org.poo.modelo;

import java.time.LocalDateTime;

public class Reporte {
    private int id;
    private String tipo;
    private LocalDateTime fechaGeneracion;
    private String contenido;

    public Reporte(int id, String tipo, String contenido) {
        this.id = id;
        this.tipo = tipo;
        this.fechaGeneracion = LocalDateTime.now();
        this.contenido = contenido;
    }

    public void generar() {
        System.out.println("Generando reporte tipo: " + tipo);
    }

    public byte[] exportarPDF() {
        return contenido.getBytes();
    }
}
