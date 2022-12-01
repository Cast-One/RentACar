package com.castillo.rentacar.Models;

import java.util.Date;

public class Renta{
    Sucursal sucursal;
    TipoAuto tipoAuto;
    Vehiculo vehiculo;
    Cliente cliente;
    Gerente gerente;
    Date fecha_renta;
    Double precio;
    Tarjeta tarjeta;
    Double pago;

    public Renta(Sucursal sucursal, TipoAuto tipoAuto, Vehiculo vehiculo, Cliente cliente, Gerente gerente, Date fecha_renta, Double precio, Tarjeta tarjeta, Double pago) {
        this.sucursal = sucursal;
        this.tipoAuto = tipoAuto;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.gerente = gerente;
        this.fecha_renta = fecha_renta;
        this.precio = precio;
        this.tarjeta = tarjeta;
        this.pago = pago;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public TipoAuto getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(TipoAuto tipoAuto) {
        this.tipoAuto = tipoAuto;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }
}