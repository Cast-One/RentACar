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

import java.util.Random;

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
            if (checkFields()){
                int randomIdNumber = new Random().nextInt(1445) + 329030;
                Vehiculo vehiculo = new Vehiculo(
                        randomIdNumber,
                        binding.textMarca.getText().toString(),
                        binding.textModel.getText().toString(),
                        Short.parseShort(binding.textYear.getText().toString()),
                        Long.parseLong(binding.textKilometraje.getText().toString()),
                        binding.textMatricula.getText().toString(),
                        Integer.parseInt(binding.textNumeroPlazas.getText().toString()),
                        Float.parseFloat(binding.textPrecio.getText().toString()));

                activity.getRentCarTools().showToas("Auto Agregado", GenericToast.SUCCESS);
                activity.getRentCarManager().addCar(activity.getIndex_category(), vehiculo, getContext());
                activity.adapter.notifyDataSetChanged();
                activity.getSupportFragmentManager().popBackStackImmediate();
            }
        });
    }


    boolean checkFields(){
        if (activity.rentCarTools.emptyField(binding.textMarca)){
            activity.rentCarTools.showToas("Por favor escribe la marca del vehiculo", GenericToast.WARNING);
            return false;
        }
        if (activity.rentCarTools.emptyField(binding.textModel)){
            activity.rentCarTools.showToas("Escribe el modelo del Vehiculo", GenericToast.WARNING);
            return false;
        }

        if (activity.rentCarTools.emptyField(binding.textMatricula)){
            activity.rentCarTools.showToas("Revisa que la matricula sea correcta", GenericToast.WARNING);
            return false;
        }

        if (activity.rentCarTools.emptyField(binding.textYear)){
            activity.rentCarTools.showToas("Ingresa el año del vehiculo", GenericToast.WARNING);
            return false;
        }

        if (activity.rentCarTools.emptyField(binding.textMatricula)){
            activity.rentCarTools.showToas("Ingresa la matrícula", GenericToast.WARNING);
            return false;
        }

        if (!activity.getRentCarManager().validateMatricula(binding.textMatricula.getText().toString())) {
            activity.rentCarTools.showToas("Esa matrícula ya se encuentra registrada", GenericToast.WARNING);
            return false;
        }


        if (activity.rentCarTools.emptyField(binding.textNumeroPlazas)){
            activity.rentCarTools.showToas("Digita el número de plazas (asientos)", GenericToast.WARNING);
            return false;
        }
        if (activity.rentCarTools.emptyField(binding.textKilometraje)){
            activity.rentCarTools.showToas("Digita el kilometraje del vehiculo", GenericToast.WARNING);
            return false;
        }
        if (activity.rentCarTools.emptyField(binding.textPrecio)){
            activity.rentCarTools.showToas("Escribe el precio del vehiculo", GenericToast.WARNING);
            return false;
        }


        return true;
    }

}