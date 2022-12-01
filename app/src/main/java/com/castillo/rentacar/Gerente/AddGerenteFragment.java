package com.castillo.rentacar.Gerente;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aidev.generictoast.GenericToast;
import com.castillo.rentacar.Clients.ClientesCatalaogActivity;
import com.castillo.rentacar.Models.Cliente;
import com.castillo.rentacar.Models.Gerente;
import com.castillo.rentacar.R;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.FragmentAddCClientBinding;
import com.castillo.rentacar.databinding.FragmentAddGerenteBinding;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddGerenteFragment} factory method to
 * create an instance of this fragment.
 */
public class AddGerenteFragment extends Fragment {

    FragmentAddGerenteBinding binding;
    GerenteCatalogActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentAddGerenteBinding.inflate(getLayoutInflater());

        activity = (GerenteCatalogActivity) getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = binding.getRoot();

        listeners();
        return view;
    }

    public void listeners(){
        binding.buttonCreateUser.setOnClickListener(view -> {

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

                int randomManagerNumber = new Random().nextInt(1445) + 329030;

                Gerente gerente = new Gerente(binding.editTextNombre.getText().toString(), apellido_Pat, apellido_Mat, charGenero, fechaNacimiento, binding.editTextCurp.getText().toString(), String.valueOf(randomManagerNumber));
                activity.getRentCarManager().addStaff(gerente, getContext());
                activity.getSupportFragmentManager().popBackStackImmediate();
                activity.getAdapter().notifyDataSetChanged();
                RentCarTools.hideKeyboard(activity);
            }
        });
    }


    boolean checkFields(){
        if (activity.rentCarTools.emptyField(binding.editTextNombre)){
            activity.rentCarTools.showToas("Por favor revisa el campo nombre", GenericToast.WARNING);
            return false;
        }
        if (activity.rentCarTools.emptyField(binding.editTextGenero)){
            activity.rentCarTools.showToas("Escribe el género en el campo correspondiente", GenericToast.WARNING);
            return false;
        }

        if (activity.rentCarTools.emptyField(binding.editTextFechaNacimiento)){
            activity.rentCarTools.showToas("Ingresa la fecha de nacimiento", GenericToast.WARNING);
            return false;
        }
        if (activity.rentCarTools.emptyField(binding.editTextCurp)){
            activity.rentCarTools.showToas("El CURP no es válido", GenericToast.WARNING);
            return false;
        }
        if (binding.editTextCurp.getText().toString().length() <18 || binding.editTextCurp.getText().toString().length() > 18){
            activity.rentCarTools.showToas("El CURP debe tener 18 caracteres", GenericToast.WARNING);
            return false;
        }

        return true;
    }


}