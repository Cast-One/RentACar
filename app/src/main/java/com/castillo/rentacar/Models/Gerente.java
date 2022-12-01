package com.castillo.rentacar.Models;

import java.util.Date;

public class Gerente extends Persona{
    String num_empleado;

    public Gerente(String nombre, String paterno, String materno, char genero, Date fecha_nacimiento, String curp, String num_empleado) {
        super(nombre, paterno, materno, genero, fecha_nacimiento, curp);
        this.num_empleado = num_empleado;
    }

    public String getNum_empleado() {
        return num_empleado;
    }
}
