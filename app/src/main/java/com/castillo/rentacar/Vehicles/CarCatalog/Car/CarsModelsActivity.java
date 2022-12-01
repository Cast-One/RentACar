package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.R;
import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.ActivityCarsModelsBinding;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

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

        RecyclerView recyclerView = binding.list;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new VehiculoRecyclerViewAdapter(this, rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos(), index_category);
        recyclerView.setAdapter(adapter);

        listeners();
    }

    private void listeners() {
        new ClickShrinkEffect(binding.imgButtonAdd);

        binding.imgButtonAdd.setOnClickListener(v -> {
            rentCarTools.openFragment(R.id.fragmentView, new AddCarFragment(index_category), getSupportFragmentManager().beginTransaction());
        });
    }
}