package com.gastos.controlgastosrest.DTO;

import com.gastos.controlgastosrest.modelos.UsuariosModelo;

public class LoginDTO {
    private String nombre;
    private String contrasenia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
