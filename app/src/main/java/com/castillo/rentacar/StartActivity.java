package com.castillo.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.Vehicles.CarsCatalogActivity;
import com.castillo.rentacar.databinding.ActivityStartBinding;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

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

        rentCarManager.listarVehiculos();
        rentCarManager.listarCategoriasVehiculos();

        listeners();
    }

    private void listeners() {
        new ClickShrinkEffect(binding.textButtonStart);

        binding.textButtonStart.setOnClickListener(v ->
                tools.nextActivityFinish(CarsCatalogActivity.class));

    }


}