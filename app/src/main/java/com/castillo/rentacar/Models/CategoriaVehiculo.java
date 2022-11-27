package com.castillo.rentacar.Models;

import java.util.ArrayList;
import java.util.List;

public class CategoriaVehiculo {
    List<Vehiculo> lista_vehiculos;
    TipoAuto enum_tipo_auto;

    public CategoriaVehiculo(List<Vehiculo> lista_vehiculos, TipoAuto enum_tipo_auto) {
        this.lista_vehiculos = lista_vehiculos;
        this.enum_tipo_auto = enum_tipo_auto;
    }

}
