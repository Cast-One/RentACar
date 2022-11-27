package com.castillo.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.databinding.ActivityMainBinding;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        listeners();
    }

    private void listeners() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);

        binding.cardHatchback.setOnClickListener(v-> {
            bundle.putString("type_car", getString(R.string.type_car_hatchback));
            intent.putExtras(bundle);
            startActivity(intent);
        });

        binding.cardSedan.setOnClickListener(v-> {
            bundle.putString("type_car", getString(R.string.type_car_sedan));
            intent.putExtras(bundle);
            startActivity(intent);
        });

        binding.cardCamioneta.setOnClickListener(v-> {
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