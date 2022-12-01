package com.castillo.rentacar.Models;

import java.util.List;

public class Staff {
    List<Gerente> gerenteList;

    public Staff(List<Gerente> gerenteList) {
        this.gerenteList = gerenteList;
    }

    public List<Gerente> getGerenteList() {
        return gerenteList;
    }

    public void setGerenteList(List<Gerente> gerenteList) {
        this.gerenteList = gerenteList;
    }
}
