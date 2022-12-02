package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aidev.generictoast.GenericToast;
import com.castillo.rentacar.Models.StatusCar;
import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.R;
import com.castillo.rentacar.databinding.FragmentVehiculoBinding;

import java.util.List;

public class VehiculoRecyclerViewAdapter extends RecyclerView.Adapter<VehiculoRecyclerViewAdapter.ViewHolder> {

    private final List<Vehiculo> mValues;
    CarsModelsActivity activity;
    Context context;
    int index_category;

    public VehiculoRecyclerViewAdapter(Context context, List<Vehiculo> items, int index_category) {
        this.context = context;
        mValues = items;
        this.index_category = index_category;
        activity = (CarsModelsActivity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentVehiculoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.modelo.setText( holder.mItem.getModelo());
        holder.marca.setText(holder.mItem.getMarca());
        holder.ano.setText("Año: "+holder.mItem.getAnio());
        holder.kilometraje.setText("Kilometraje " + holder.mItem.getKilometraje());
        holder.matricucla.setText(holder.mItem.getMatricula());
        holder.placas.setText("Plazas: " + holder.mItem.getNumero_plazas());
        holder.tipoAuto.setText(activity.getRentCarManager().getLista_CategoriasVehiculos().get(activity.getIndex_category()).getEnum_tipo_auto().getNombre());

        holder.touch_linear.setOnClickListener(v -> {
            if (holder.mItem.getStatusCar() == StatusCar.RENTADO || holder.mItem.getStatusCar() == StatusCar.ENTREGADO){
                activity.getRentCarTools().showToas("EL vehículo se encuentra en renta.", GenericToast.ERROR);
                return;
            }
            if (holder.mItem.getStatusCar() ==StatusCar.BAJA){
                activity.getRentCarTools().showToas("EL vehículo se encuentra dado de baja.", GenericToast.ERROR);
                return;
            }
            if (holder.mItem.getStatusCar() ==StatusCar.VENTA){
                activity.getRentCarTools().showToas("EL vehículo se encuentra vendido.", GenericToast.ERROR);
                return;
            }
            activity.rentCarTools.openFragment(R.id.fragmentView, new ActionsCarFragment(position), activity.getSupportFragmentManager().beginTransaction());
        });

        if (holder.mItem.getStatusCar() != StatusCar.ACTIVO) {
            holder.linearLayoutStatus.setVisibility(View.VISIBLE);
            holder.textViewStatus.setText(holder.mItem.getStatusCar().getNombre());
        } else {
            holder.linearLayoutStatus.setVisibility(View.GONE);
        }

        if (holder.mItem.getSeguro() != null) {
            holder.seguro.setVisibility(View.VISIBLE);
            holder.seguro.setText("Seguro: " + holder.mItem.getSeguro());
        } else {
            holder.seguro.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Vehiculo mItem;
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

        public ViewHolder(FragmentVehiculoBinding binding) {
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