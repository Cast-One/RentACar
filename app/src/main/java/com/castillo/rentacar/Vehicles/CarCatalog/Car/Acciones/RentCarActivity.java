package com.castillo.rentacar.Vehicles.CarCatalog.Car.Acciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.braintreepayments.cardform.view.CardForm;
import com.castillo.rentacar.Models.Cliente;
import com.castillo.rentacar.Models.Gerente;
import com.castillo.rentacar.Models.StatusCar;
import com.castillo.rentacar.Models.Sucursal;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.ActivityRentCarBinding;

import java.util.ArrayList;
import java.util.List;

public class RentCarActivity extends AppCompatActivity {

    ActivityRentCarBinding binding;

    RentCarManager rentCarManager;
    RentCarTools rentCarTools;

    int index_category;
    int index_car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRentCarBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rentCarTools = new RentCarTools(this);
        rentCarManager = RentCarManager.getInstance(this);

        index_category = getIntent().getIntExtra("index_category", 0);
        index_car = getIntent().getIntExtra("index_car", 0);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getClients());
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        binding.spinerClient.setAdapter(spinnerArrayAdapter);

        ArrayAdapter<String> spinnerArrayAdapterGerentes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getGerentes());
        spinnerArrayAdapterGerentes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        binding.spinerGerente.setAdapter(spinnerArrayAdapterGerentes);

        ArrayAdapter<String> spinnerArrayAdapterSucursales = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getSucursales());
        spinnerArrayAdapterSucursales.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        binding.spinnerSucursal.setAdapter(spinnerArrayAdapterSucursales);

        binding.cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .cardholderName(CardForm.FIELD_DISABLED)
                .postalCodeRequired(false)
                .mobileNumberRequired(false)
                .mobileNumberExplanation("SMS is required on this number")
                .actionLabel("Purchase")
                .setup(this);

        showData();
        listeners();
    }

    public void showData(){
        Vehiculo vehiculo = rentCarManager.getLista_CategoriasVehiculos().get(index_category).
                getLista_vehiculos().get(index_car);
        binding.modelo.setText(vehiculo.getModelo());
        binding.marca.setText(vehiculo.getMarca());
        binding.ano.setText(String.format("Año: %s", vehiculo.getAnio()));
        binding.kilometraje.setText("Kilometraje " + vehiculo.getKilometraje());
        binding.matricula.setText(vehiculo.getMatricula());
        binding.placa.setText("Plazas: " + vehiculo.getNumero_plazas());
        binding.tipoAuto.setText(rentCarManager.getLista_CategoriasVehiculos().get(index_category).getEnum_tipo_auto().getNombre());
    }

    public void listeners(){
        binding.buttonRentcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rentCarManager.changeStatus(index_category, index_car, StatusCar.RENTADO, RentCarActivity.this);
            }
        });
    }

    public String[] getClients(){
        List<String> clientesList = new ArrayList<>();
        clientesList.add("-- Cliente --");
        for (Cliente cliente: rentCarManager.getClienteList()) {
            clientesList.add(cliente.getNombre());
        }
        String[] stringArray = clientesList.toArray(new String[0]);
        return stringArray;
    }

    public String[] getGerentes(){
        List<String> gerenteList = new ArrayList<>();
        gerenteList.add("-- Gerente --");
        for (Gerente gerente: rentCarManager.getStaffList()) {
            gerenteList.add(gerente.getNombre());
        }
        String[] stringArray = gerenteList.toArray(new String[0]);
        return stringArray;
    }

    public String[] getSucursales(){
        List<String> sucursalList = new ArrayList<>();
        sucursalList.add("-- Sucursal --");
        for (Sucursal sucursal: Sucursal.values()) {
            sucursalList.add(sucursal.getNombre());
        }
        String[] stringArray = sucursalList.toArray(new String[0]);
        return stringArray;
    }
}