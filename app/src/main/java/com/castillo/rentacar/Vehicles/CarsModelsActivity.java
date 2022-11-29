package com.castillo.rentacar.Vehicles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.ActivityCarsModelsBinding;

import java.util.ArrayList;

public class CarsModelsActivity extends AppCompatActivity {

    ActivityCarsModelsBinding binding;
    RentCarManager rentCarManager;
    RentCarTools rentCarTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarsModelsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rentCarTools = new RentCarTools(this);
        rentCarManager = RentCarManager.getInstance(this);

        if (getIntent().getStringExtra("type_car") != null){
            showList(getIntent().getStringExtra("type_car"));
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    public void showList(String type_car){
        type_car = type_car.toUpperCase();

        RecyclerView recyclerView = binding.list;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        VehiculoRecyclerViewAdapter adapter = new VehiculoRecyclerViewAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);

        switch (type_car){
            case "HATCHBACK":
                adapter = new VehiculoRecyclerViewAdapter(this, rentCarManager.getLista_CategoriasVehiculos().get(0).getLista_vehiculos());
            break;
            case "SEDAN":
                adapter = new VehiculoRecyclerViewAdapter(this, rentCarManager.getLista_CategoriasVehiculos().get(1).getLista_vehiculos());
            break;
            case "CAMIONETA":
                adapter = new VehiculoRecyclerViewAdapter(this, rentCarManager.getLista_CategoriasVehiculos().get(2).getLista_vehiculos());
            break;
            case "PICKUP":
                adapter = new VehiculoRecyclerViewAdapter(this, rentCarManager.getLista_CategoriasVehiculos().get(3).getLista_vehiculos());
            break;
        }

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}