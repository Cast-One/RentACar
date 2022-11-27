package com.castillo.rentacar.Models;

public enum TipoAuto {
    HATCHBACK("Hatchback"),
    SEDAN("Sedan"),
    CAMIONETA("Camioneta"),
    PICKUP("Pickup");

    private final String nombre;
    private TipoAuto(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}