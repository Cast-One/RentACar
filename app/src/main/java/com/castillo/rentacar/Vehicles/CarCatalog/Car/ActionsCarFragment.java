package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aidev.generictoast.GenericToast;
import com.castillo.rentacar.Models.StatusCar;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.R;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.Acciones.RentCarActivity;
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


        binding.baja.setVisibility(View.VISIBLE);
        binding.mantenimiento.setVisibility(View.VISIBLE);
        binding.seguro.setVisibility(View.VISIBLE);
        binding.robo.setVisibility(View.VISIBLE);
        binding.venta.setVisibility(View.VISIBLE);
        binding.renta.setVisibility(View.VISIBLE);
        binding.entrega.setVisibility(View.VISIBLE);

        switch (activity.getRentCarManager().getLista_CategoriasVehiculos().
                get(activity.getIndex_category()).getLista_vehiculos().
                get(index_car).getStatusCar()){
            case EN_MANTENIMIENTO:
            case ROBADO:
                binding.renta.setVisibility(View.GONE);
                binding.venta.setVisibility(View.GONE);
                binding.entrega.setVisibility(View.GONE);
                binding.mantenimiento.setVisibility(View.GONE);
                binding.robo.setVisibility(View.GONE);
                break;
        }
        if (activity.getRentCarManager().getLista_CategoriasVehiculos().
                get(activity.getIndex_category()).getLista_vehiculos().
                get(index_car).getStatusCar() == StatusCar.ACTIVO){
            binding.venta.setVisibility(View.VISIBLE);
            binding.renta.setVisibility(View.VISIBLE);
            binding.entrega.setVisibility(View.VISIBLE);

        }

        listenners();

        return view;
    }

    public void listenners(){
        binding.voidScreen.setOnClickListener(view -> {});
        binding.baja.setOnClickListener(view -> {
            activity.getRentCarTools().showToas("Auto En Baja", GenericToast.ERROR);
            activity.getRentCarManager().changeStatus(activity.getIndex_category(), index_car, StatusCar.BAJA, getContext());
            activity.CheckFilterAndUpdate();
            activity.getSupportFragmentManager().popBackStackImmediate();
        });
        binding.mantenimiento.setOnClickListener(view -> {
            activity.getRentCarTools().showToas("Auto en mantenimiento", GenericToast.WARNING);
            activity.getRentCarManager().changeStatus(activity.getIndex_category(), index_car, StatusCar.EN_MANTENIMIENTO, getContext());
            activity.CheckFilterAndUpdate();
            activity.getSupportFragmentManager().popBackStackImmediate();
        });
        binding.seguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.getRentCarTools().showToas("Seguro asignado", GenericToast.SUCCESS);
                activity.getRentCarManager().asegurarCar(activity.getIndex_category(), index_car, getContext());
                activity.CheckFilterAndUpdate();
                activity.getSupportFragmentManager().popBackStackImmediate();
            }
        });
        binding.robo.setOnClickListener(view -> {
            activity.getRentCarTools().showToas("Auto reportado como Robado", GenericToast.WARNING);
            activity.getRentCarManager().changeStatus(activity.getIndex_category(), index_car, StatusCar.ROBADO, getContext());
            activity.CheckFilterAndUpdate();
            activity.getSupportFragmentManager().popBackStackImmediate();
        });
        binding.renta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getContext(), RentCarActivity.class);
                bundle.putInt("index_category", activity.getIndex_category());
                bundle.putInt("index_car", index_car);
                intent.putExtras(bundle);
                activity.startActivity(intent);
                activity.getSupportFragmentManager().popBackStackImmediate();
            }
        });
    }
}