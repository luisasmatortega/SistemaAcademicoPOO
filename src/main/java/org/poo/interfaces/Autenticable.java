package org.poo.interfaces;

public interface Autenticable {
    boolean iniciarSesion(String correo, String clave);
    void cerrarSesion();
}
