package com.castillo.rentacar.Models;

import java.util.List;

public class Clients {
    List<Cliente> clientes;

    public Clients(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
