package com.castillo.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.Clients.ClientesCatalaogActivity;
import com.castillo.rentacar.Gerente.GerenteCatalogActivity;
import com.castillo.rentacar.Models.CategoriaVehiculo;
import com.castillo.rentacar.Models.Cliente;
import com.castillo.rentacar.Models.Clients;
import com.castillo.rentacar.Models.Gerente;
import com.castillo.rentacar.Models.Renta;
import com.castillo.rentacar.Models.RentsCar;
import com.castillo.rentacar.Models.Staff;
import com.castillo.rentacar.Models.Store;
import com.castillo.rentacar.Models.TipoAuto;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.Renta.RentActivity;
import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.Acciones.RentCarActivity;
import com.castillo.rentacar.Vehicles.CarCatalog.CarsCatalogActivity;
import com.castillo.rentacar.databinding.ActivityStartBinding;
import com.google.gson.Gson;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StartActivity extends AppCompatActivity {
    ActivityStartBinding binding;
    RentCarTools tools;
    RentCarManager rentCarManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        tools = new RentCarTools(this);
        rentCarManager = RentCarManager.getInstance(this);

        Gson gson = new Gson();

        String jsonStore = rentCarManager.getPreference(StartActivity.this, getResources().getString(R.string.key_store));
        Store storeCars = gson.fromJson(jsonStore, Store.class);
        if (storeCars != null) {
            rentCarManager.setListaCategoriasVehiculos(storeCars.getCategoriaVehiculoList(), this);
        } else {
            listarCategoriasVehiculos();
        }

        String jsonClients = rentCarManager.getPreference(StartActivity.this, getResources().getString(R.string.key_clients));
        Clients clients = gson.fromJson(jsonClients, Clients.class);
        if (clients != null) {
            rentCarManager.setClienteList(clients.getClientes(), this);
        } else {
            listarClientes();
        }

        String jsonStaff = rentCarManager.getPreference(StartActivity.this, getResources().getString(R.string.key_staff));
        Staff staff = gson.fromJson(jsonStaff, Staff.class);
        if (staff != null) {
            rentCarManager.setStaffList(staff.getGerenteList(), this);
        } else {
            listarStaff();
        }

        String jsonRents = rentCarManager.getPreference(StartActivity.this, getResources().getString(R.string.key_rents));
        RentsCar rentsCar = gson.fromJson(jsonRents, RentsCar.class);
        if (rentsCar != null) {
            rentCarManager.setRentaList(rentsCar.getRentaList(), this);
        } else {
            listarStaff();
        }

        listeners();
    }

    public void listarCategoriasVehiculos(){
        List<Vehiculo> vehiculos_HATCHBACK = new ArrayList<>();
        List<Vehiculo> vehiculos_SEDAN = new ArrayList<>();
        List<Vehiculo> vehiculos_CAMIONETA = new ArrayList<>();
        List<Vehiculo> vehiculos_PICKUP = new ArrayList<>();

        vehiculos_HATCHBACK.add(new Vehiculo(1, "Cupra", "León", (short)2019, 37151, "H00-01", 2, 12213f));
        vehiculos_HATCHBACK.add(new Vehiculo(2, "BMW", "Serie 1", (short)2019, 48066, "H00-02", 1, 263289f));
        vehiculos_HATCHBACK.add(new Vehiculo(3, "Fiat", "Argo", (short)2018, 56758, "H00-03", 3, 246775f));
        vehiculos_HATCHBACK.add(new Vehiculo(4, "Hyundai", "Grand i10", (short)2020, 35740, "H00-04", 4, 185569f));

        vehiculos_SEDAN.add(new Vehiculo(5, "Chevrolet", "Civic", (short)2020, 30183, "S00-05", 2, 266392f));
        vehiculos_SEDAN.add(new Vehiculo(6, "Honda", "Civic", (short)2019, 75034, "S00-06", 3, 91106f));
        vehiculos_SEDAN.add(new Vehiculo(7, "Hyundai", "Elantra", (short)2021, 32841, "S00-07", 4, 274176f));
        vehiculos_SEDAN.add(new Vehiculo(8, "KIA", "Forte", (short)2020, 43833, "S00-08", 4, 258932f));

        vehiculos_CAMIONETA.add(new Vehiculo(9, "Toyota", "Tundra", (short)2018, 78934, "C00-09", 3, 180494f));
        vehiculos_CAMIONETA.add(new Vehiculo(10, "Ford", "F-150 Raptor", (short)2020, 37202, "C00-10", 2, 234620f));
        vehiculos_CAMIONETA.add(new Vehiculo(11, "Jeep", "Gladiator", (short)2021, 48505, "C00-11", 2, 85210f));
        vehiculos_CAMIONETA.add(new Vehiculo(12, "GMC", "Sierra 1500", (short)2017, 50729, "C00-12", 4, 116344f));

        vehiculos_PICKUP.add(new Vehiculo(13, "Chevrolet", "Cheyenne", (short)2019, 50729, "P00-13", 4, 106783));
        vehiculos_PICKUP.add(new Vehiculo(14, "Chevrolet", "Montana", (short)2019, 52087, "P00-14", 2, 97380f));
        vehiculos_PICKUP.add(new Vehiculo(15, "Ford", "Maverick Híbrida", (short)2018, 63898, "P00-15", 2, 80418f));
        vehiculos_PICKUP.add(new Vehiculo(16, "Ford", "Ranger", (short)2020, 61534, "P00-16", 4, 87788f));

        List<CategoriaVehiculo> listaCategoriasVehiculos = new ArrayList<>();
        listaCategoriasVehiculos.add(new CategoriaVehiculo(vehiculos_HATCHBACK, TipoAuto.HATCHBACK));
        listaCategoriasVehiculos.add(new CategoriaVehiculo(vehiculos_SEDAN, TipoAuto.SEDAN));
        listaCategoriasVehiculos.add(new CategoriaVehiculo(vehiculos_CAMIONETA, TipoAuto.CAMIONETA));
        listaCategoriasVehiculos.add(new CategoriaVehiculo(vehiculos_PICKUP, TipoAuto.PICKUP));

        rentCarManager.setListaCategoriasVehiculos(listaCategoriasVehiculos, this);
    }

    public void listarStaff(){
        List<Gerente> staffList = new ArrayList<>(); //HEGM990902MDFRZR05
        staffList.add(new Gerente("Zaira", "Silvestre", "Vilar", 'F', new Date(), "ZSV887755MDFRZR93", "8352678321"));
        staffList.add(new Gerente("Adil", "Lobato", "Andrade", 'M', new Date(), "ALB825610MDFRZR93", "2749300273"));
        staffList.add(new Gerente("Aurelia", "Aurelia", "Palomino", 'F', new Date(), "AAP827381MDRZRK23", "2735182001"));
        staffList.add(new Gerente("Xavier", "Mendoza", "Aguilar", 'M', new Date(), "XMA82639KIRZ082", "7273645127"));
        staffList.add(new Gerente("Oscar", "Arteaga", "Chamorro", 'M', new Date(), "OAZ726491MDJRZR92", "008263124"));

        rentCarManager.setStaffList(staffList, this);
    }

    public void listarClientes(){
        List<Cliente> clienteList = new ArrayList<>(); //HEGM990902MDFRZR05
        clienteList.add(new Cliente("Zaira", "Silvestre", "Vilar", 'F', new Date(), "ZSV887755MDFRZR93", "8352678321"));
        clienteList.add(new Cliente("Adil", "Lobato", "Andrade", 'M', new Date(), "ALB825610MDFRZR93", "2749300273"));
        clienteList.add(new Cliente("Aurelia", "Aurelia", "Palomino", 'F', new Date(), "AAP827381MDRZRK23", "2735182001"));
        clienteList.add(new Cliente("Xavier", "Mendoza", "Aguilar", 'M', new Date(), "XMA82639KIRZ082", "7273645127"));
        clienteList.add(new Cliente("Oscar", "Arteaga", "Chamorro", 'M', new Date(), "OAZ726491MDJRZR92", "008263124"));


        rentCarManager.setClienteList(clienteList, this);
    }

    private void listeners() {
        new ClickShrinkEffect(binding.layoutVehicle);
        new ClickShrinkEffect(binding.layoutClients);
        new ClickShrinkEffect(binding.layoutGerentes);
        new ClickShrinkEffect(binding.layoutRentas);
        binding.layoutVehicle.setOnClickListener(view -> tools.nextActivity(CarsCatalogActivity.class));
        binding.layoutClients.setOnClickListener(view -> tools.nextActivity(ClientesCatalaogActivity.class));
        binding.layoutGerentes.setOnClickListener(view -> tools.nextActivity(GerenteCatalogActivity.class));
        binding.layoutRentas.setOnClickListener(view -> tools.nextActivity(RentActivity.class));

    }

}