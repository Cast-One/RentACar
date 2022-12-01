package com.castillo.rentacar.Models;

public enum StatusCar {
    ACTIVO("Activo"),
    RENTADO("Rentado"),
    EN_MANTENIMIENTO("Mantenimiento"),
    ROBADO("Robado"),
    BAJA("Baja");

    private final String nombre;

    private StatusCar(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
