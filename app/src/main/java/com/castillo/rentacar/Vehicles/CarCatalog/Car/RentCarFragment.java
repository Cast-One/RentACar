package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castillo.rentacar.Models.StatusCar;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.CarsModelsActivity;
import com.castillo.rentacar.databinding.FragmentRentCarBinding;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

public class RentCarFragment extends Fragment {

    CarsModelsActivity activity;
    FragmentRentCarBinding binding;
    int index_car;

    public RentCarFragment() {}

    public RentCarFragment(int index_car) {
        this.index_car = index_car;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentRentCarBinding.inflate(getLayoutInflater());
        activity = (CarsModelsActivity) getContext();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = binding.getRoot();

        new ClickShrinkEffect(binding.textButtonFinish);

//        if (vehiculo != null){
//            binding.textCarName.setText(String.format("%s%s", vehiculo.getMarca(), vehiculo.getModelo()));
////            Toast.makeText(requireContext(), vehiculo.getMarca() + " " +vehiculo.getModelo(), Toast.LENGTH_LONG).show();
//        }

        listenners();

        return view;
    }

    public void listenners(){
        binding.textButtonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.getRentCarManager().changeStatus(activity.getIndex_category(),
                        index_car, StatusCar.RENTADO, getContext());
                activity.getAdapter().notifyDataSetChanged();
                activity.getSupportFragmentManager().popBackStackImmediate();
            }
        });
    }
}