package com.castillo.rentacar.Models;

import java.util.Date;

public class Persona{
    String nombre;
    String paterno;
    String materno;
    char genero;
    Date fecha_nacimiento;
    String curp;

    public Persona(String nombre, String paterno, String materno, char genero, Date fecha_nacimiento, String curp) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public char getGenero() {
        return genero;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getCurp() {
        return curp;
    }
}
