package com.example.proyecto.Utilidades;

public class Utilidades {

    // Constantes Base de Datos
    public static final String bd_name = "koksalcars";
    public static final int bd_version = 1;

    // Constantes campos tabla usuarios

    public static final String tabla_usuarios = "usuarios";

    public static final String campo_nombre = "nombre";

    public static final String campo_correo = "correo";

    public static final String campo_clave = "clave";

    public static final String crear_tabla_usuarios = "CREATE TABLE IF NOT EXISTS " + tabla_usuarios + "(" + campo_correo +
            " TEXT PRIMARY KEY NOT NULL," + campo_nombre + " TEXT NOT NULL," + campo_clave + " TEXT NOT NULL);";


}
