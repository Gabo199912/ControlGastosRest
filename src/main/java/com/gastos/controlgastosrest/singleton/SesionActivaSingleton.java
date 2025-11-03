package com.gastos.controlgastosrest.singleton;


public class SesionActivaSingleton {
    private static Integer idUsuario;
    private static String nombreUsuario;
    private static String correoUsuario;
    private static String estadoUsuario;

    public static Integer getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(Integer idUsuario) {
        SesionActivaSingleton.idUsuario = idUsuario;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        SesionActivaSingleton.nombreUsuario = nombreUsuario;
    }

    public static String getCorreoUsuario() {
        return correoUsuario;
    }

    public static void setCorreoUsuario(String correoUsuario) {
        SesionActivaSingleton.correoUsuario = correoUsuario;
    }

    public static String getEstadoUsuario() {
        return estadoUsuario;
    }

    public static void setEstadoUsuario(String estadoUsuario) {
        SesionActivaSingleton.estadoUsuario = estadoUsuario;
    }
}
