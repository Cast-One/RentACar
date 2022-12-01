package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aidev.generictoast.GenericToast;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.R;
import com.castillo.rentacar.databinding.FragmentAddCarBinding;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

public class AddCarFragment extends Fragment {
    FragmentAddCarBinding binding;
    CarsModelsActivity activity;

    public AddCarFragment() {}


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
        new ClickShrinkEffect(binding.buttonNewCar);

        binding.buttonNewCar.setOnClickListener(v -> {
            Vehiculo vehiculo = new Vehiculo(1, "Vaqui", "Vaqui", (short)2019, 37151, "H00-01", 2, 12213f);
            activity.getRentCarTools().showToas("Auto Agregado", GenericToast.SUCCESS);
            activity.getRentCarManager().addCar(activity.getIndex_category(), vehiculo, getContext());
            activity.adapter.notifyDataSetChanged();
            activity.getSupportFragmentManager().popBackStackImmediate();
        });
    }


}