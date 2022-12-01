package com.castillo.rentacar.Vehicles.CarCatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.ActivityCarsCatalogBinding;

public class CarsCatalogActivity extends AppCompatActivity {

    ActivityCarsCatalogBinding binding;
    RentCarTools rentCarTools;
    RentCarManager rentCarManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarsCatalogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rentCarTools = new RentCarTools(this);
        rentCarManager = RentCarManager.getInstance(this);

        RecyclerView recyclerView = binding.list;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        CategoryRecyclerViewAdapter adapter = new CategoryRecyclerViewAdapter(this, rentCarManager.getLista_CategoriasVehiculos());
        recyclerView.setAdapter(adapter);

    }

}