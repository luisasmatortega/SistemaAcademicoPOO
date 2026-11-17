package org.poo;

import org.poo.enums.DiaSemana;
import org.poo.modelo.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SISTEMA ACADÉMICO - POO (CONSOLA) ===");

        Administrador admin = new Administrador(1, "Luis", "Asmat", "71418954",
                "admin@utp.edu.pe", "1234", "Jefe RRHH");
        PeriodoAcademico periodo = precargarDatos(admin);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opción: ");
            ejecutarOpcion(opcion, scanner, admin, periodo);
        } while (opcion != 9);

        scanner.close();
    }

    // ==========================================
    // PRECARGA
    // ==========================================
    private static PeriodoAcademico precargarDatos(Administrador admin) {
        System.out.println("Inicializando datos precargados...");

        Docente docente1 = new Docente(2, "Benito", "Gonzalez", "71434895",
                "C25317536@utp.edu.pe", "1234", "POO");
        admin.nuevoDocente(docente1);

        Estudiante est1 = new Estudiante(3, "Diana", "Aliaga", "71369781",
                "U25311645@utp.edu.pe", "1234", "U25230967");
        admin.nuevoAlumno(est1);

        PeriodoAcademico periodo = new PeriodoAcademico(1, "2026-I",
                LocalDate.of(2026, 3, 1), LocalDate.of(2026, 7, 30));

        Curso cursoPoo = new Curso("INF201", "Programación Orientada a Objetos", 4, 30);
        cursoPoo.asignarDocente(docente1);
        cursoPoo.agregarHorario(new Horario(1, DiaSemana.LUNES,
                LocalTime.of(8, 0), LocalTime.of(10, 0), "Aula 301"));
        admin.nuevoCurso(cursoPoo);

        Matricula mat1 = admin.matricularAlumno(est1, cursoPoo, periodo);
        if (mat1 != null) {
            mat1.agregarNota(new Nota(1, "Evaluación Continua 1", 18.0, 0.4));
            mat1.agregarNota(new Nota(2, "Examen Final", 16.0, 0.6));
        }

        Pago pago1 = new Pago(1, 450.00, "Matrícula 2026-I");
        pago1.confirmar();

        System.out.println("¡Datos precargados con éxito!\n");
        return periodo;
    }

    // ==========================================
    // MENÚ
    // ==========================================
    private static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("      MENÚ PRINCIPAL - SISTEMA ACADÉMICO");
        System.out.println("========================================");
        System.out.println("1. Listar Alumnos");
        System.out.println("2. Registrar Nuevo Alumno");
        System.out.println("3. Listar Docentes");
        System.out.println("4. Registrar Nuevo Docente");
        System.out.println("5. Listar Cursos");
        System.out.println("6. Registrar Nuevo Curso");
        System.out.println("7. Matricular Alumno en Curso");
        System.out.println("8. Listar Matrículas");
        System.out.println("9. Salir");
    }

    private static void ejecutarOpcion(int opcion, Scanner sc, Administrador admin, PeriodoAcademico periodo) {
        switch (opcion) {
            case 1 -> admin.listarAlumnos();
            case 2 -> registrarAlumno(sc, admin);
            case 3 -> admin.listarDocentes();
            case 4 -> registrarDocente(sc, admin);
            case 5 -> admin.listarCursos();
            case 6 -> registrarCurso(sc, admin);
            case 7 -> matricularAlumno(sc, admin, periodo);
            case 8 -> admin.listarMatriculas();
            case 9 -> System.out.println("Saliendo del sistema académico. ¡Hasta luego!");
            default -> System.out.println("Opción inválida. Intente de nuevo.");
        }
    }

    // ==========================================
    // ACCIONES DEL MENÚ
    // ==========================================
    private static void registrarAlumno(Scanner sc, Administrador admin) {
        int id = leerEntero(sc, "ID del alumno: ");
        String nombres = leerTexto(sc, "Nombres: ");
        String apellidos = leerTexto(sc, "Apellidos: ");
        String dni = leerTexto(sc, "DNI: ");
        String correo = leerTexto(sc, "Correo: ");
        String pass = leerTexto(sc, "Contraseña: ");
        String codigo = leerTexto(sc, "Código de estudiante (ej. U25...): ");

        admin.nuevoAlumno(new Estudiante(id, nombres, apellidos, dni, correo, pass, codigo));
    }

    private static void registrarDocente(Scanner sc, Administrador admin) {
        int id = leerEntero(sc, "ID del docente: ");
        String nombres = leerTexto(sc, "Nombres: ");
        String apellidos = leerTexto(sc, "Apellidos: ");
        String dni = leerTexto(sc, "DNI: ");
        String correo = leerTexto(sc, "Correo: ");
        String pass = leerTexto(sc, "Contraseña: ");
        String especialidad = leerTexto(sc, "Especialidad: ");

        admin.nuevoDocente(new Docente(id, nombres, apellidos, dni, correo, pass, especialidad));
    }

    private static void registrarCurso(Scanner sc, Administrador admin) {
        String codigo = leerTexto(sc, "Código del curso (ej. MAT101): ");
        String nombre = leerTexto(sc, "Nombre del curso: ");
        int creditos = leerEntero(sc, "Créditos: ");
        int vacantes = leerEntero(sc, "Vacantes: ");

        admin.nuevoCurso(new Curso(codigo, nombre, creditos, vacantes));
    }

    private static void matricularAlumno(Scanner sc, Administrador admin, PeriodoAcademico periodo) {
        String codEst = leerTexto(sc, "Ingrese el código del estudiante a matricular: ");
        Estudiante estudiante = admin.buscarAlumno(codEst);
        if (estudiante == null) {
            System.out.println("❌ Estudiante no encontrado con ese código.");
            return;
        }

        admin.listarCursos();
        String codCurso = leerTexto(sc, "Ingrese el código del curso a matricular (ej. INF201): ");
        Curso curso = admin.buscarCurso(codCurso);
        if (curso == null) {
            System.out.println("❌ Curso no encontrado con ese código.");
            return;
        }

        admin.matricularAlumno(estudiante, curso, periodo);
    }

    // ==========================================
    // LECTURA DE DATOS
    // ==========================================
    private static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}