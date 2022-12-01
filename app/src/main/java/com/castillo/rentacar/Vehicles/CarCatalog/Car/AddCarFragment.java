package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.R;
import com.castillo.rentacar.databinding.FragmentAddCarBinding;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

public class AddCarFragment extends Fragment {
    FragmentAddCarBinding binding;
    CarsModelsActivity activity;
    int index_category;

    public AddCarFragment() {}

    public AddCarFragment(int index_category) {
        this.index_category = index_category;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentAddCarBinding.inflate(getLayoutInflater());

        activity = (CarsModelsActivity) getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = binding.getRoot();

        listeners();

        return view;
    }

    private void listeners() {
        new ClickShrinkEffect(binding.textButtonFinish);

        binding.textButtonFinish.setOnClickListener(v -> {
            activity.rentCarManager.getLista_CategoriasVehiculos().get(index_category).getLista_vehiculos().add(new Vehiculo(1, "Vaqui", "Vaqui", (short)2019, 37151, "H00-01", 2, 12213f));
            activity.adapter.notifyDataSetChanged();
            activity.getSupportFragmentManager().popBackStackImmediate();
        });
    }


}