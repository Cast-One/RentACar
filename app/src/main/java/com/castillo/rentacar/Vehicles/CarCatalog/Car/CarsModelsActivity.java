package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;
import com.castillo.rentacar.Models.StatusCar;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.R;
import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.ActivityCarsModelsBinding;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

import java.util.ArrayList;
import java.util.List;

public class CarsModelsActivity extends AppCompatActivity {

    ActivityCarsModelsBinding binding;
    RentCarManager rentCarManager;
    RentCarTools rentCarTools;

    VehiculoRecyclerViewAdapter adapter;
    int index_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarsModelsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rentCarTools = new RentCarTools(this);
        rentCarManager = RentCarManager.getInstance(this);

        index_category = getIntent().getIntExtra("index_category", 0);


        binding.list.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new VehiculoRecyclerViewAdapter(this, rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos(), index_category);
        binding.list.setAdapter(adapter);

        listeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new VehiculoRecyclerViewAdapter(this, rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos(), index_category);
        binding.list.setAdapter(adapter);
    }

    private void listeners() {
        new ClickShrinkEffect(binding.imgButtonAdd);

        binding.imgButtonAdd.setOnClickListener(v -> {
            rentCarTools.openFragment(R.id.fragmentView, new AddCarFragment(), getSupportFragmentManager().beginTransaction());
        });

        binding.buttonGroupLordOfTheRings.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(final int position) {
                CheckFilterAndUpdate();
            }
        });

    }

    public void  CheckFilterAndUpdate(){
        List<Vehiculo> vehiculosFilter = new ArrayList<>();
        // Handle stuff here
        switch (binding.buttonGroupLordOfTheRings.getPosition()) {
            case 0:
                adapter = new VehiculoRecyclerViewAdapter(CarsModelsActivity.this, rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos(), index_category);
                binding.list.setAdapter(adapter);
                break;
            case 1:
                for (Vehiculo vehicle: rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos()) {
                    if (vehicle.getStatusCar() == StatusCar.ACTIVO){
                        vehiculosFilter.add(vehicle);
                    }
                }
                adapter = new VehiculoRecyclerViewAdapter(CarsModelsActivity.this, vehiculosFilter, index_category);
                binding.list.setAdapter(adapter);
                break;
            case 2:
                for (Vehiculo vehicle: rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos()) {
                    if (vehicle.getStatusCar() == StatusCar.EN_MANTENIMIENTO){
                        vehiculosFilter.add(vehicle);
                    }
                }
                adapter = new VehiculoRecyclerViewAdapter(CarsModelsActivity.this, vehiculosFilter, index_category);
                binding.list.setAdapter(adapter);
                break;
            case 3:
                for (Vehiculo vehicle: rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos()) {
                    if (vehicle.getStatusCar() == StatusCar.ROBADO){
                        vehiculosFilter.add(vehicle);
                    }
                }
                adapter = new VehiculoRecyclerViewAdapter(CarsModelsActivity.this, vehiculosFilter, index_category);
                binding.list.setAdapter(adapter);
                break;
            case 4:
                for (Vehiculo vehicle: rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos()) {
                    if (vehicle.getStatusCar() == StatusCar.BAJA){
                        vehiculosFilter.add(vehicle);
                    }
                }
                adapter = new VehiculoRecyclerViewAdapter(CarsModelsActivity.this, vehiculosFilter, index_category);
                binding.list.setAdapter(adapter);
                break;
        }
    }

    public RentCarManager getRentCarManager() {
        return rentCarManager;
    }

    public RentCarTools getRentCarTools() {
        return rentCarTools;
    }

    public VehiculoRecyclerViewAdapter getAdapter() {
        return adapter;
    }

    public int getIndex_category() {
        return index_category;
    }
}