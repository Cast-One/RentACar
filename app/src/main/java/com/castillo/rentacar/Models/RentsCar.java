package com.castillo.rentacar.Models;

import java.util.List;

public class RentsCar {
    List<Renta> rentaList;

    public RentsCar(List<Renta> rentaList) {
        this.rentaList = rentaList;
    }

    public List<Renta> getRentaList() {
        return rentaList;
    }

    public void setRentaList(List<Renta> rentaList) {
        this.rentaList = rentaList;
    }
}
