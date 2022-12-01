package com.castillo.rentacar.Clients;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.R;
import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.AddCarFragment;
import com.castillo.rentacar.Vehicles.CarCatalog.CategoryRecyclerViewAdapter;
import com.castillo.rentacar.databinding.ActivityClientesCatalaogBinding;

public class ClientesCatalaogActivity extends AppCompatActivity {

    ActivityClientesCatalaogBinding binding;
    ClientesCatalogoRecyclerViewAdapter adapter;

    RentCarTools rentCarTools;
    RentCarManager rentCarManager;

    public ClientesCatalogoRecyclerViewAdapter getAdapter() {
        return adapter;
    }
    public RentCarManager getRentCarManager() {
        return rentCarManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityClientesCatalaogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rentCarTools = new RentCarTools(this);
        rentCarManager = RentCarManager.getInstance(this);

        RecyclerView recyclerView = binding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ClientesCatalogoRecyclerViewAdapter(rentCarManager.getClienteList(), this);
        recyclerView.setAdapter(adapter);

        listenners();
    }

    public void listenners() {
        binding.addUser.setOnClickListener(view -> rentCarTools.openFragment(R.id.fragmentView, new AddCClientFragment(), getSupportFragmentManager().beginTransaction()));
    }
}