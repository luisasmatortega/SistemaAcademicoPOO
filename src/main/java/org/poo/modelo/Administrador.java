package org.poo.modelo;

public class Administrador extends Persona{
    private String cargo;

    public Administrador(
            int id, String nombres, String apellidos, String dni,
            String correo, String contrasena, String cargo
    ) {
        super(id, nombres, apellidos, dni, correo, contrasena);
        this.cargo = cargo;
    }

    public void registrarEstudiante(Estudiante e) {
        System.out.println("Estudiante registrado: " + e.getNombreCompleto());
    }

    public void registrarDocente(Docente d) {
        System.out.println("Docente registrado: " + d.getNombreCompleto());
    }

    public void crearCurso(Curso c) {
        System.out.println("Curso creado: " + c.getNombre());
    }

    public Reporte generarReporte(String tipo) {
        return new Reporte(1, tipo, "Reporte generado por admin " + getNombreCompleto());
    }

    @Override
    public String getRol() {
        return "ADMINISTRADOR";
    }
}
