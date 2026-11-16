package org.poo.modelo;

import org.poo.enums.EstadoPago;

import java.time.LocalDate;

public class Pago {
    private int id;
    private double monto;
    private LocalDate fecha;
    private String concepto;
    private EstadoPago estado;

    public Pago(int id, double monto, String concepto) {
        this.id = id;
        this.monto = monto;
        this.fecha = LocalDate.now();
        this.concepto = concepto;
        this.estado = EstadoPago.PENDIENTE;
    }

    public void confirmar() { this.estado = EstadoPago.COMPLETADO; }
    public void anular() { this.estado = EstadoPago.ANULADO; }
    public EstadoPago getEstado() { return estado; }
}
