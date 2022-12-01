package com.castillo.rentacar.Vehicles;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.databinding.FragmentRentCarBinding;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

public class RentCarFragment extends Fragment {

    FragmentRentCarBinding binding;
    Vehiculo vehiculo;

    public RentCarFragment() {}

    public RentCarFragment(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentRentCarBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = binding.getRoot();

        new ClickShrinkEffect(binding.textButtonFinish);

        if (vehiculo != null){
            binding.textCarName.setText(String.format("%s%s", vehiculo.getMarca(), vehiculo.getModelo()));
//            Toast.makeText(requireContext(), vehiculo.getMarca() + " " +vehiculo.getModelo(), Toast.LENGTH_LONG).show();
        }


        return view;
    }
}