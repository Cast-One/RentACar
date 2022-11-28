package com.castillo.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.ActivityCarsCatalogBinding;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

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

        listeners();
    }

    private void listeners() {
        new ClickShrinkEffect(binding.cardHatchback);
        new ClickShrinkEffect(binding.cardSedan);
        new ClickShrinkEffect(binding.cardCamioneta);
        new ClickShrinkEffect(binding.cardPickup);

        Bundle bundle = new Bundle();
        Intent intent = new Intent(CarsCatalogActivity.this, CarsModelsActivity.class);

        binding.cardHatchback.setOnClickListener(v-> {
            rentCarManager.listarCategoriasVehiculos();
            bundle.putString("type_car", getString(R.string.type_car_hatchback));
            intent.putExtras(bundle);
            startActivity(intent);
        });

        binding.cardSedan.setOnClickListener(v-> {
            rentCarManager.listarCategoriasVehiculos();
            bundle.putString("type_car", getString(R.string.type_car_sedan));
            intent.putExtras(bundle);
            startActivity(intent);
        });

        binding.cardCamioneta.setOnClickListener(v-> {
            rentCarManager.listarCategoriasVehiculos();
            bundle.putString("type_car", getString(R.string.type_car_camioneta));
            intent.putExtras(bundle);
            startActivity(intent);
        });

        binding.cardPickup.setOnClickListener(v-> {
            bundle.putString("type_car", getString(R.string.type_car_pickup));
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}