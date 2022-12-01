package com.castillo.rentacar.Models;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class CategoriaVehiculo {
    List<Vehiculo> lista_vehiculos;
    TipoAuto enum_tipo_auto;

    public CategoriaVehiculo(List<Vehiculo> lista_vehiculos, TipoAuto enum_tipo_auto) {
        this.lista_vehiculos = lista_vehiculos;
        this.enum_tipo_auto = enum_tipo_auto;
    }

    public List<Vehiculo> getLista_vehiculos() {
        return lista_vehiculos;
    }

    public void setLista_vehiculos(List<Vehiculo> lista_vehiculos) {
        this.lista_vehiculos = lista_vehiculos;
    }

    public TipoAuto getEnum_tipo_auto() {
        return enum_tipo_auto;
    }

    public void setEnum_tipo_auto(TipoAuto enum_tipo_auto) {
        this.enum_tipo_auto = enum_tipo_auto;
    }
}
