package com.castillo.rentacar.Renta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.castillo.rentacar.R;
import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.VehiculoRecyclerViewAdapter;
import com.castillo.rentacar.databinding.ActivityCarsModelsBinding;
import com.castillo.rentacar.databinding.ActivityRentBinding;

import android.os.Bundle;
import android.view.View;

public class RentActivity extends AppCompatActivity {

    ActivityRentBinding binding;
    RentCarManager rentCarManager;
    RentCarTools rentCarTools;

    ActiveRentsRecyclerViewAdapter adapter;

    public RentCarManager getRentCarManager() {
        return rentCarManager;
    }

    public RentCarTools getRentCarTools() {
        return rentCarTools;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rentCarTools = new RentCarTools(this);
        rentCarManager = RentCarManager.getInstance(this);


        binding.list.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new ActiveRentsRecyclerViewAdapter(rentCarManager.getRentaList(), this);
        binding.list.setAdapter(adapter);
    }
}