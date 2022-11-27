package com.castillo.rentacar.Models;

import java.util.Date;

public class Renta{
    Vehiculo vehiculo;
    Cliente cliente;
    Gerente gerente;
    Date fecha_renta;

    public Renta(Vehiculo vehiculo, Cliente cliente, Gerente gerente, Date fecha_renta) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.gerente = gerente;
        this.fecha_renta = fecha_renta;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Date getFecha_renta() {
        return fecha_renta;
    }

    public void setFecha_renta(Date fecha_renta) {
        this.fecha_renta = fecha_renta;
    }
}