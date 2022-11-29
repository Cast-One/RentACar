package com.castillo.rentacar.Vehicles;

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
    Vehiculo vehiculo;

    public AddCarFragment() {}

    public AddCarFragment(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentAddCarBinding.inflate(getLayoutInflater());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = binding.getRoot();

        new ClickShrinkEffect(binding.textButtonFinish);

        if (vehiculo != null){
            Toast.makeText(requireContext(), vehiculo.getMarca() + " " +vehiculo.getModelo(), Toast.LENGTH_LONG).show();
        }


        return view;
    }
}