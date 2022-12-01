package com.castillo.rentacar.Models;

public enum Sucursal {
    PORTUGAL("Portugaal"),
    TOKIO("Tokio"),
    BERLIN("Berlín"),
    DEMBER("Dember"),
    CHICAGO("Chicago"),
    MOSKÚ("Moskú"),
    LISBOA("Lisboa"),
    LONDRES("Londres"),
    NUEVA_YORK("Nueva York"),
    PARIS("Paris");

    private final String nombre;
    private Sucursal(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
