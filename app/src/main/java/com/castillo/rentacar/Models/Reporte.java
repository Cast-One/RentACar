package com.castillo.rentacar.Models;

public class Reporte{
    Cliente cliente;
    Gerente gerente;

    public Reporte(Cliente cliente, Gerente gerente) {
        this.cliente = cliente;
        this.gerente = gerente;
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
}