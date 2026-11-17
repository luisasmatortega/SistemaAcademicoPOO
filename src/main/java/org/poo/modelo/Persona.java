package org.poo.modelo;

import org.poo.interfaces.Autenticable;

public abstract class Persona implements Autenticable {
    private int id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String correo;
    private String contrasena;

    public Persona(int id, String nombres, String apellidos, String dni, String correo, String contrasena) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    @Override
    public boolean iniciarSesion(String correo, String clave) {
        return this.correo.equalsIgnoreCase(correo) && this.contrasena.equals(clave);
    }

    @Override
    public void cerrarSesion() {
        System.out.println("Sesión cerrada para: " + getNombreCompleto());
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    public int getId() { return id; }
    public String getCorreo() { return correo; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setDni(String dni) { this.dni = dni; }


    public abstract String getRol();
}
