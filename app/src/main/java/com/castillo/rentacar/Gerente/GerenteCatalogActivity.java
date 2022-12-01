package com.castillo.rentacar.Gerente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.castillo.rentacar.Clients.AddCClientFragment;
import com.castillo.rentacar.Clients.ClientesCatalogoRecyclerViewAdapter;
import com.castillo.rentacar.R;
import com.castillo.rentacar.Tools.RentCarManager;
import com.castillo.rentacar.Tools.RentCarTools;
import com.castillo.rentacar.databinding.ActivityClientesCatalaogBinding;
import com.castillo.rentacar.databinding.ActivityGerenteCatalogBinding;

public class GerenteCatalogActivity extends AppCompatActivity {

    ActivityGerenteCatalogBinding binding;
    GerenteCatalogRecyclerViewAdapter adapter;

    RentCarTools rentCarTools;
    RentCarManager rentCarManager;

    public GerenteCatalogRecyclerViewAdapter getAdapter() {
        return adapter;
    }
    public RentCarManager getRentCarManager() {
        return rentCarManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGerenteCatalogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rentCarTools = new RentCarTools(this);
        rentCarManager = RentCarManager.getInstance(this);

        RecyclerView recyclerView = binding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GerenteCatalogRecyclerViewAdapter(rentCarManager.getStaffList(), this);
        recyclerView.setAdapter(adapter);

        listenners();
    }

    public void listenners() {
        binding.addUser.setOnClickListener(view -> rentCarTools.openFragment(R.id.fragmentView, new AddGerenteFragment(), getSupportFragmentManager().beginTransaction()));
    }
}