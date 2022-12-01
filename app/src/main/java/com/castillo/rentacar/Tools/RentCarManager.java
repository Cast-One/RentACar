package com.castillo.rentacar.Tools;

import android.content.Context;
import android.content.SharedPreferences;

import com.castillo.rentacar.Models.CategoriaVehiculo;
import com.castillo.rentacar.Models.Cliente;
import com.castillo.rentacar.Models.Clients;
import com.castillo.rentacar.Models.Gerente;
import com.castillo.rentacar.Models.Staff;
import com.castillo.rentacar.Models.StatusCar;
import com.castillo.rentacar.Models.Store;
import com.castillo.rentacar.Models.TipoAuto;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RentCarManager {

    private static final String PREFS_NAME = "preferenceName";
    private static RentCarManager instance = null;
    private RentCarManager(Context context){}

    public static synchronized RentCarManager getInstance(Context context){
        if (null == instance){
            instance = new RentCarManager(context);
        }

        return instance;
    }

    public boolean setCustomObjectPreference(Context context, String key, Object value){
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(key, json);
        return prefsEditor.commit();
    }
    public String getPreference(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, "");
    }

    /** Categoria de Vehículos **/
    List<CategoriaVehiculo> listaCategoriasVehiculos = new ArrayList<>();
    public List<CategoriaVehiculo> getLista_CategoriasVehiculos() {
        return listaCategoriasVehiculos;
    }

    public void setListaCategoriasVehiculos(List<CategoriaVehiculo> listaCategoriasVehiculos, Context context) {
        this.listaCategoriasVehiculos = listaCategoriasVehiculos;
        setCustomObjectPreference(context, context.getResources().getString(R.string.key_store), new Store(this.listaCategoriasVehiculos));
    }

    public void deleteCar(int index_category, int index_car, Context context){
        listaCategoriasVehiculos.get(index_category).getLista_vehiculos().remove(index_car);
        setListaCategoriasVehiculos(this.listaCategoriasVehiculos, context);
    }

    public void addCar(int index_category, Vehiculo vehiculo, Context context){
        listaCategoriasVehiculos.get(index_category).getLista_vehiculos().add(vehiculo);
        setListaCategoriasVehiculos(this.listaCategoriasVehiculos, context);
    }

    public void changeStatus(int index_category, int index_car, StatusCar statusCar, Context context){
        listaCategoriasVehiculos.get(index_category).
                getLista_vehiculos().get(index_car).
                setStatusCar(statusCar);
        setListaCategoriasVehiculos(this.listaCategoriasVehiculos, context);
    }
    /** Clientes **/
    List<Cliente> clienteList = new ArrayList<>();
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList, Context context) {
        this.clienteList = clienteList;
        setCustomObjectPreference(context, context.getResources().getString(R.string.key_clients), new Clients(this.clienteList));
    }

    public void addClient(Cliente cliente, Context context){
        this.clienteList.add(cliente);
        setClienteList(this.clienteList, context);
    }

    public void removeClient(int index_client, Context context){
        this.clienteList.remove(index_client);
        setClienteList(this.clienteList, context);
    }

    /** Staff **/
    List<Gerente> staffList = new ArrayList<>();
    public List<Gerente> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Gerente> staffList, Context context) {
        this.staffList = staffList;
        setCustomObjectPreference(context, context.getResources().getString(R.string.key_staff), new Staff(this.staffList));
    }

    public void addStaff(Gerente gerente, Context context){
        this.staffList.add(gerente);
        setStaffList(this.staffList, context);
    }

    public void removeStaff(int index_gerente, Context context){
        this.staffList.remove(index_gerente);
        setStaffList(this.staffList, context);
    }
}
