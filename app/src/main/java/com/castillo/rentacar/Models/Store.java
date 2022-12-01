package com.castillo.rentacar.Models;

import java.util.List;

public class Store {
    List<CategoriaVehiculo> categoriaVehiculoList;

    public Store(List<CategoriaVehiculo> categoriaVehiculoList) {
        this.categoriaVehiculoList = categoriaVehiculoList;
    }

    public List<CategoriaVehiculo> getCategoriaVehiculoList() {
        return categoriaVehiculoList;
    }

    public void setCategoriaVehiculoList(List<CategoriaVehiculo> categoriaVehiculoList) {
        this.categoriaVehiculoList = categoriaVehiculoList;
    }
}
