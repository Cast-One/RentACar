package com.castillo.rentacar.Gerente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castillo.rentacar.Clients.ClientesCatalaogActivity;
import com.castillo.rentacar.Models.Cliente;
import com.castillo.rentacar.Models.Gerente;
import com.castillo.rentacar.R;
import com.castillo.rentacar.databinding.FragmentAddCClientBinding;
import com.castillo.rentacar.databinding.FragmentAddGerenteBinding;

import java.util.Date;

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
            activity.getRentCarManager().addStaff(new Gerente("Maria","Sanz",  "Sanz", 'F', new Date(), "MSS776421KDYZE82", "1234567890'"), getContext());
            activity.getSupportFragmentManager().popBackStackImmediate();
            activity.getAdapter().notifyDataSetChanged();
        });
    }
}