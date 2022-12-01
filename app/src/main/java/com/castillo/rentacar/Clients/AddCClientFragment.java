package com.castillo.rentacar.Clients;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castillo.rentacar.Models.Cliente;
import com.castillo.rentacar.R;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.CarsModelsActivity;
import com.castillo.rentacar.databinding.FragmentAddCClientBinding;

import java.util.Date;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddCClientFragment} factory method to
 * create an instance of this fragment.
 */
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
                activity.getRentCarManager().addClient(new Cliente("Maria","Sanz",  "Sanz", 'F', new Date(), "MSS776421KDYZE82", "1234567890'"), getContext());
                activity.getSupportFragmentManager().popBackStackImmediate();
                activity.getAdapter().notifyDataSetChanged();
            }
        });
    }
}