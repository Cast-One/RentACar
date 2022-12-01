package com.castillo.rentacar.Models;

import java.util.Date;

public class Cliente extends Persona{
    String num_cliente;

    public Cliente(String nombre, String paterno, String materno, char genero, Date fecha_nacimiento, String curp, String num_cliente) {
        super(nombre, paterno, materno, genero, fecha_nacimiento, curp);
        this.num_cliente = num_cliente;
    }

    public String getNum_cliente() {
        return num_cliente;
    }
}
