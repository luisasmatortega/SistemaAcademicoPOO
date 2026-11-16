package org.poo;

import org.poo.enums.DiaSemana;
import org.poo.modelo.*;

import java.time.LocalDate;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA ACADÉMICO - PRECARGA DE DATOS (MÍNIMO 7 OBJETOS) ===");

        // 1. Instanciación de Personas (Polimorfismo / Herencia)
        Persona admin = new Administrador(1, "Luis", "Asmat", "71418954", "admin@utp.edu.pe", "1234", "Jefe RRHH");
        Docente docente1 = new Docente(2, "Benito", "Gonzalez", "71434895", "C25317536@utp.edu.pe", "1234", "POO");
        Estudiante est1 = new Estudiante(3, "Diana", "Aliaga", "71369781", "U25311645@utp.edu.pe", "1234", "U25230967");

        // 2. Periodo Académico
        PeriodoAcademico periodo2026 = new PeriodoAcademico(1, "2026-I", LocalDate.of(2026, 3, 1), LocalDate.of(2026, 7, 30));

        // 3. Curso y Horarios (Composición)
        Curso cursoPoo = new Curso("INF201", "Programación Orientada a Objetos", 4, 30);
        cursoPoo.asignarDocente(docente1);
        Horario h1 = new Horario(1, DiaSemana.LUNES, LocalTime.of(8, 0), LocalTime.of(10, 0), "Aula 301");
        cursoPoo.agregarHorario(h1);

        // 4. Matrícula (Asociación Estudiante - Curso - Periodo)
        Matricula mat1 = new Matricula(est1, cursoPoo, periodo2026);
        mat1.activar();

        // 5. Notas y Asistencias (Composición en Matrícula)
        Nota n1 = new Nota(1, "Evaluación Continua 1", 18.0, 0.4);
        Nota n2 = new Nota(2, "Examen Final", 16.0, 0.6);
        mat1.agregarNota(n1);
        mat1.agregarNota(n2);

        // 6. Pago
        Pago pago1 = new Pago(1, 450.00, "Matrícula 2026-I");
        pago1.confirmar();

        // 7. Reporte
        Reporte rep1 = ((Administrador) admin).generarReporte("Rendimiento Académico");

        // Impresión de comprobación
        System.out.println("Usuario activo: " + admin.getNombreCompleto() + " | Rol: " + admin.getRol());
        System.out.println("Curso: " + cursoPoo.getNombre() + " dictado por: " + docente1.getNombreCompleto());
        System.out.println("Estudiante: " + est1.getNombreCompleto() + " | Promedio POO: " + mat1.calcularPromedio());
        System.out.println("Estado de Pago: " + pago1.getEstado());
    }
}