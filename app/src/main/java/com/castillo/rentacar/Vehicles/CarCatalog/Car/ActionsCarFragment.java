package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aidev.generictoast.GenericToast;
import com.castillo.rentacar.Models.StatusCar;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.R;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.CarsModelsActivity;
import com.castillo.rentacar.databinding.FragmentRentCarBinding;

import com.realpacific.clickshrinkeffect.ClickShrinkEffect;

public class ActionsCarFragment extends Fragment {

    CarsModelsActivity activity;
    FragmentRentCarBinding binding;
    int index_car;

    public ActionsCarFragment() {}

    public ActionsCarFragment(int index_car) {
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
        
        listenners();

        return view;
    }

    public void listenners(){
        binding.baja.setOnClickListener(view -> {
            activity.getRentCarTools().showToas("Auto Eliminado", GenericToast.ERROR);
            activity.getRentCarManager().deleteCar(activity.getIndex_category(), index_car, getContext());
            activity.getAdapter().notifyDataSetChanged();
            activity.getSupportFragmentManager().popBackStackImmediate();
        });
        binding.mantenimiento.setOnClickListener(view -> {
            activity.getRentCarTools().showToas("Auto en mantenimiento", GenericToast.WARNING);
            activity.getRentCarManager().changeStatus(activity.getIndex_category(), index_car, StatusCar.EN_MANTENIMIENTO, getContext());
            activity.getAdapter().notifyDataSetChanged();
            activity.getSupportFragmentManager().popBackStackImmediate();
        });
        binding.seguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.getRentCarTools().showToas("Seguro asignado", GenericToast.SUCCESS);
                activity.getRentCarManager().asegurarCar(activity.getIndex_category(), index_car, getContext());
                activity.getAdapter().notifyDataSetChanged();
                activity.getSupportFragmentManager().popBackStackImmediate();
            }
        });
        binding.robo.setOnClickListener(view -> {
            activity.getRentCarTools().showToas("Auto reportado como Robado", GenericToast.WARNING);
            activity.getRentCarManager().changeStatus(activity.getIndex_category(), index_car, StatusCar.ROBADO, getContext());
            activity.getAdapter().notifyDataSetChanged();
            activity.getSupportFragmentManager().popBackStackImmediate();
        });
    }
}