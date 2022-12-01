package com.castillo.rentacar.Tools;

import android.content.Context;
import android.content.SharedPreferences;

import com.castillo.rentacar.Models.CategoriaVehiculo;
import com.castillo.rentacar.Models.TipoAuto;
import com.castillo.rentacar.Models.Vehiculo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RentCarManager {

    private static final String PREFS_NAME = "preferenceName";
    private static RentCarManager instance = null;
    private RentCarManager(Context context){}

    // Facilitar el uso del Context
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
    public boolean removePreference(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(key);
        return editor.commit();
    }

    // Lista de Categorías de Vehiculos
    List<CategoriaVehiculo> listaCategoriasVehiculos = new ArrayList<>();
    public List<CategoriaVehiculo> getLista_CategoriasVehiculos() {
        return listaCategoriasVehiculos;
    }

    public void deleteCar(int index_category, int index_car){
        listaCategoriasVehiculos.get(index_category).getLista_vehiculos().remove(index_car);
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

        listaCategoriasVehiculos.add(new CategoriaVehiculo(vehiculos_HATCHBACK, TipoAuto.HATCHBACK));
        listaCategoriasVehiculos.add(new CategoriaVehiculo(vehiculos_SEDAN, TipoAuto.SEDAN));
        listaCategoriasVehiculos.add(new CategoriaVehiculo(vehiculos_CAMIONETA, TipoAuto.CAMIONETA));
        listaCategoriasVehiculos.add(new CategoriaVehiculo(vehiculos_PICKUP, TipoAuto.PICKUP));
    }

}
