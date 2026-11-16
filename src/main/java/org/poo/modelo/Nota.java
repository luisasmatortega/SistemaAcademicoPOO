package org.poo.modelo;

public class Nota {
    private int id;
    private String tipoEvaluacion;
    private double calificacion;
    private double peso;

    public Nota(int id, String tipoEvaluacion, double calificacion, double peso) {
        this.id = id;
        this.tipoEvaluacion = tipoEvaluacion;
        this.calificacion = calificacion;
        this.peso = peso;
    }

    public boolean esValida() {
        return calificacion >= 0 && calificacion <= 20;
    }

    public double getPonderado() {
        return calificacion * peso;
    }

    public double getCalificacion() { return calificacion; }
}
