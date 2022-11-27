package com.castillo.rentacar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    RentCarTools tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        tools = new RentCarTools(this);

        listeners();
    }

    private void listeners() {
        binding.textButtonStart.setOnClickListener(v -> {
            tools.nextActivityFinish(MainActivity.class);
        });

    }


}