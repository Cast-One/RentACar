package com.castillo.rentacar.Models;

import java.util.Date;

public class Renta{
    Sucursal sucursal;
    TipoAuto tipoAuto;
    Vehiculo vehiculo;
    Cliente cliente;
    Gerente gerente;
    Date fecha_renta;

    Tarjeta tarjeta;

    Double precio;
    Double pago;
    Double deuda;
    Integer diasAdeuda;

    Integer index_Category;
    Integer index_Car;

    public Renta(Sucursal sucursal, TipoAuto tipoAuto, Vehiculo vehiculo, Cliente cliente, Gerente gerente, Date fecha_renta, Double precio, Tarjeta tarjeta, Double pago, Integer index_Category, Integer index_Car) {
        this.sucursal = sucursal;
        this.tipoAuto = tipoAuto;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.gerente = gerente;
        this.fecha_renta = fecha_renta;
        this.precio = precio;
        this.tarjeta = tarjeta;
        this.pago = pago;
        this.deuda = 0.0;
        this.diasAdeuda = 0;
        this.index_Category = index_Category;
        this.index_Car = index_Car;
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

    public Double getDeuda() {
        return deuda;
    }

    public void setDeuda(Double deuda) {
        this.deuda = deuda;
    }

    public Integer getDiasAdeuda() {
        return diasAdeuda;
    }

    public void setDiasAdeuda(Integer diasAdeuda) {
        this.diasAdeuda = diasAdeuda;
    }

    public Integer getIndex_Category() {
        return index_Category;
    }

    public void setIndex_Category(Integer index_Category) {
        this.index_Category = index_Category;
    }

    public Integer getIndex_Car() {
        return index_Car;
    }

    public void setIndex_Car(Integer index_Car) {
        this.index_Car = index_Car;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }
}