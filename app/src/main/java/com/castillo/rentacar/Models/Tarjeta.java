package com.castillo.rentacar.Models;

import java.util.Date;

public class Tarjeta{
    String num_tarjeta;
    Date fecha_vencimiento;
    short cvc;

    public Tarjeta(String num_tarjeta, Date fecha_vencimiento, short cvc) {
        this.num_tarjeta = num_tarjeta;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cvc = cvc;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public short getCvc() {
        return cvc;
    }

    public void setCvc(short cvc) {
        this.cvc = cvc;
    }
}
