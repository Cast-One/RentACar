package com.castillo.rentacar.Clients;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aidev.generictoast.GenericToast;
import com.castillo.rentacar.Models.Cliente;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.FragmentAddCClientBinding;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class AddCClientFragment extends Fragment {

    FragmentAddCClientBinding binding;
    ClientesCatalaogActivity activity;

    public AddCClientFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentAddCClientBinding.inflate(getLayoutInflater());

        activity = (ClientesCatalaogActivity) getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = binding.getRoot();

        listeners();

        return view;
    }

    public void listeners(){
        binding.buttonCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkFields()){
                    String apellido_Pat = "";
                    String apellido_Mat = "";
                    if (binding.editTextApellidoP.getText() != null){
                        apellido_Pat = binding.editTextApellidoP.getText().toString();
                    }

                    if (binding.editTextApellidoM.getText() != null){
                        apellido_Mat = binding.editTextApellidoM.getText().toString();
                    }

                    char charGenero = binding.editTextGenero.getText().charAt(0);
                    Date fechaNacimiento = new Date();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                    try {
                        fechaNacimiento = dateFormat.parse(binding.editTextFechaNacimiento.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    int randomClientNumber = new Random().nextInt(1445) + 329030;

                    Cliente cliente = new Cliente(binding.editTextNombre.getText().toString(), apellido_Pat, apellido_Mat, charGenero, fechaNacimiento, binding.editTextCurp.getText().toString(), String.valueOf(randomClientNumber));
                    activity.getRentCarManager().addClient(cliente, getContext());
                    activity.getSupportFragmentManager().popBackStackImmediate();
                    activity.getAdapter().notifyDataSetChanged();
                    RentCarTools.hideKeyboard(activity);
                }
            }
        });
    }


    boolean checkFields(){
        if (activity.rentCarTools.emptyField(binding.editTextNombre)){
            activity.rentCarTools.showToas("Por favor revisa tu nombre", GenericToast.WARNING);
            return false;
        }
        if (activity.rentCarTools.emptyField(binding.editTextGenero)){
            activity.rentCarTools.showToas("Escribe tu genero en el campo correspondiente", GenericToast.WARNING);
            return false;
        }
        if (activity.rentCarTools.emptyField(binding.editTextFechaNacimiento)){
            activity.rentCarTools.showToas("Ingresa tu fecha de nacimiento", GenericToast.WARNING);
            return false;
        }
        if (activity.rentCarTools.emptyField(binding.editTextCurp)){
            activity.rentCarTools.showToas("Tu CURP no es válido", GenericToast.WARNING);
            return false;
        }

        return true;
    }




}