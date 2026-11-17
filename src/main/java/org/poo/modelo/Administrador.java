package org.poo.modelo;

import org.poo.repositorios.RepositorioCursos;
import org.poo.repositorios.RepositorioDocente;
import org.poo.repositorios.RepositorioEstudiantes;
import org.poo.repositorios.RepositorioMatriculas;


public class Administrador extends Persona{
    private String cargo;
    private final RepositorioEstudiantes estudiantes = new RepositorioEstudiantes();
    private final RepositorioDocente docentes = new RepositorioDocente();
    private final RepositorioCursos cursos = new RepositorioCursos();
    private final RepositorioMatriculas matriculas = new RepositorioMatriculas();

    public Administrador(
            int id, String nombres, String apellidos, String dni,
            String correo, String contrasena, String cargo
    ) {
        super(id, nombres, apellidos, dni, correo, contrasena);
        this.cargo = cargo;
    }

    // ---------- ESTUDIANTES ----------
    public void nuevoAlumno(Estudiante e) {
        estudiantes.agregar(e);
        System.out.println("Alumno registrado con éxito: " + e.getNombreCompleto());
    }

    public void modificarAlumno(String codigo, String nombre, String apellido, String dni) {
        Estudiante e = estudiantes.buscar(codigo);
        if (e == null) {
            System.out.println("No se encontró al alumno.");
            return;
        }
        e.setNombres(nombre);
        e.setApellidos(apellido);
        e.setDni(dni);
        System.out.println("Alumno modificado correctamente.");
    }

    public void eliminarAlumno(String codigo) {
        System.out.println(estudiantes.eliminar(codigo)
                ? "Alumno eliminado del sistema."
                : "Alumno no encontrado.");
    }

    public void listarAlumnos() {
        System.out.println("\n**** LISTA DE ALUMNOS REGISTRADOS ****");
        if (estudiantes.getTodos().isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        for (Estudiante e : estudiantes.getTodos()) {
            System.out.println("Código: " + e.getCodigo()
                    + " | Nombre: " + e.getNombreCompleto()
                    + " | Correo: " + e.getCorreo());
        }
    }

    @Override
    public String getRol() {
        return "ADMINISTRADOR";
    }


    // ---------- DOCENTES ----------
    public void nuevoDocente(Docente d) {
        docentes.agregar(d);
        System.out.println("Docente registrado con éxito: " + d.getNombreCompleto());
    }

    public void modificarDocente(int id, String nombre, String apellido, String especialidad) {
        Docente d = docentes.buscar(id);
        if (d == null) {
            System.out.println("Docente no encontrado.");
            return;
        }
        d.setNombres(nombre);
        d.setApellidos(apellido);
        d.setEspecialidad(especialidad);
        System.out.println("Docente modificado correctamente.");
    }

    public void eliminarDocente(int id) {
        System.out.println(docentes.eliminar(id)
                ? "Docente eliminado del sistema."
                : "Docente no encontrado.");
    }

    public void asignarDocente(String codigoCurso, Docente docente) {
        Curso c = cursos.buscar(codigoCurso);
        if (c == null) {
            System.out.println("Curso no encontrado para asignación.");
            return;
        }
        c.asignarDocente(docente);
        docente.getCursosAsignados().add(c); // mantiene ambos lados sincronizados
        System.out.println("Docente asignado correctamente al curso " + c.getNombre());
    }

    public void listarDocentes() {
        System.out.println("\n--- LISTA DE DOCENTES REGISTRADOS ---");
        if (docentes.getTodos().isEmpty()) {
            System.out.println("No hay docentes registrados.");
            return;
        }
        for (Docente d : docentes.getTodos()) {
            System.out.println("ID: " + d.getId() + " | Nombre: " + d.getNombreCompleto());
        }
    }

    // ---------- CURSOS ----------
    public void nuevoCurso(Curso c) {
        cursos.agregar(c);
        System.out.println("Curso creado con éxito: " + c.getNombre());
    }

    public void modificarCurso(String codigo, String nuevoNombre, int nuevosCreditos) {
        Curso c = cursos.buscar(codigo);
        if (c == null) {
            System.out.println("Curso no encontrado.");
            return;
        }
        c.actualizarCurso(nuevoNombre, nuevosCreditos, 30);
        System.out.println("Curso modificado correctamente.");
    }

    public void eliminarCurso(String codigo) {
        System.out.println(cursos.eliminar(codigo)
                ? "Curso eliminado del sistema."
                : "Curso no encontrado.");
    }

    public void listarCursos() {
        System.out.println("\n--- LISTA DE CURSOS DISPONIBLES ---");
        if (cursos.getTodos().isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        for (Curso c : cursos.getTodos()) {
            System.out.println("Código: " + c.getCodigo() + " | Nombre: " + c.getNombre());
        }
    }

    // ---------- MATRÍCULAS ----------
    public Matricula matricularAlumno(Estudiante estudiante, Curso curso, PeriodoAcademico periodo) {
        if (!curso.hayVacantes()) {
            System.out.println("Lo sentimos, no hay vacantes disponibles en el curso.");
            return null;
        }
        curso.reservarVacante();
        Matricula m = new Matricula(estudiante, curso, periodo);
        m.activar();
        matriculas.agregar(m);
        System.out.println("¡Matrícula exitosa de " + estudiante.getNombreCompleto()
                + " en el curso " + curso.getNombre() + "!");
        return m;
    }

    public void retirarAlumno(Matricula matricula) {
        matricula.cancelar();
        if (matricula.getCurso() != null) {
            matricula.getCurso().liberarVacante();
        }
        System.out.println("El alumno ha sido retirado de la matrícula.");
    }

    public void listarMatriculas() {
        System.out.println("\n--- LISTA DE MATRÍCULAS ---");
        if (matriculas.getTodos().isEmpty()) {
            System.out.println("No hay matrículas registradas.");
            return;
        }
        for (Matricula m : matriculas.getTodos()) {
            System.out.println("Alumno: " + m.getEstudiante().getNombreCompleto()
                    + " (" + m.getEstudiante().getCodigo() + ")"
                    + " | Curso: " + m.getCurso().getNombre()
                    + " | Estado: " + m.getEstado());
        }
    }

    public Estudiante buscarAlumno(String codigo) {
        return estudiantes.buscar(codigo);
    }

    public Docente buscarDocente(int id) {
        return docentes.buscar(id);
    }

    public Curso buscarCurso(String codigo) {
        return cursos.buscar(codigo);
    }
}
