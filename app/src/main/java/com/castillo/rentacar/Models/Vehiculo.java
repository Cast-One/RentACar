package com.castillo.rentacar.Models;

public class Vehiculo{
    int id;
    String marca;
    String modelo;
    short anio;
    long kilometraje;
    String matricula;
    int numero_plazas;
    float precio;
    StatusCar statusCar;

    String seguro; //Valor nulo inicial

    public void setStatusCar(StatusCar statusCar) {
        this.statusCar = statusCar;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public Vehiculo(int id, String marca, String modelo, short anio, long kilometraje, String matricula, int numero_plazas, float precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.matricula = matricula;
        this.numero_plazas = numero_plazas;
        this.precio = precio;
        this.seguro = null;
        this.statusCar = StatusCar.ACTIVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusCar getStatusCar() {
        return statusCar;
    }

    public String getSeguro() {
        return seguro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumero_plazas() {
        return numero_plazas;
    }

    public void setNumero_plazas(int numero_plazas) {
        this.numero_plazas = numero_plazas;
    }

    public float getPrecio() {
        return precio;
    }
}
