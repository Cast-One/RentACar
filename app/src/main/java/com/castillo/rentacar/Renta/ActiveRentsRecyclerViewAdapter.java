package com.castillo.rentacar.Renta;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aidev.generictoast.GenericToast;
import com.castillo.rentacar.Models.Renta;
import com.castillo.rentacar.Models.StatusCar;
import com.castillo.rentacar.R;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.ActionsCarFragment;
import com.castillo.rentacar.databinding.FragmentActiveRentsBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Renta}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ActiveRentsRecyclerViewAdapter extends RecyclerView.Adapter<ActiveRentsRecyclerViewAdapter.ViewHolder> {

    private final List<Renta> mValues;
    Context context;

    RentActivity rentActivity;

    public ActiveRentsRecyclerViewAdapter(List<Renta> items, Context context) {
        mValues = items;
        this.context = context;
        rentActivity = (RentActivity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentActiveRentsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.modelo.setText( holder.mItem.getVehiculo().getModelo());
        holder.marca.setText(holder.mItem.getVehiculo().getMarca());
        holder.ano.setText("Año: "+holder.mItem.getVehiculo().getAnio());
        holder.kilometraje.setText("Kilometraje " + holder.mItem.getVehiculo().getKilometraje());
        holder.matricucla.setText(holder.mItem.getVehiculo().getMatricula());
        holder.placas.setText("Plazas: " + holder.mItem.getVehiculo().getNumero_plazas());
        holder.tipoAuto.setText(holder.mItem.getTipoAuto().getNombre());

        holder.touch_linear.setOnClickListener(v -> {
            rentActivity.getRentCarManager().deliverCar(position, context);
            notifyDataSetChanged();
        });

        holder.linearLayoutStatus.setVisibility(View.VISIBLE);
        holder.textViewStatus.setText(holder.mItem.getVehiculo().getStatusCar().getNombre());

        holder.seguro.setVisibility(View.VISIBLE);
        if (holder.mItem.getVehiculo().getStatusCar() == StatusCar.RENTADO) {
            holder.seguro.setText("No entregado");
        } else if (holder.mItem.getVehiculo().getStatusCar() == StatusCar.ENTREGADO) {
            holder.seguro.setText("Entregado");
        } else {
            holder.seguro.setText(holder.mItem.getVehiculo().getStatusCar().getNombre());
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Renta mItem;
        TextView marca;
        TextView modelo;
        TextView ano;
        TextView kilometraje;
        TextView matricucla;
        TextView placas;
        TextView tipoAuto;
        LinearLayout linearLayoutStatus;
        LinearLayout touch_linear;
        TextView textViewStatus;
        TextView seguro;

        public ViewHolder(FragmentActiveRentsBinding binding) {
            super(binding.getRoot());
            marca = binding.marca;
            modelo = binding.modelo;
            ano = binding.ano;
            kilometraje = binding.kilometraje;
            matricucla = binding.matriccula;
            linearLayoutStatus = binding.linearStatus;
            placas = binding.placa;
            tipoAuto = binding.tipoAuto;
            touch_linear = binding.touchLinear;
            textViewStatus = binding.textStatus;
            seguro = binding.seguro;
        }

    }
}