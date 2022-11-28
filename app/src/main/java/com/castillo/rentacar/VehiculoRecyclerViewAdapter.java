package com.castillo.rentacar;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.castillo.rentacar.Models.Vehiculo;
import com.castillo.rentacar.databinding.FragmentVehiculoBinding;

import java.util.List;

public class VehiculoRecyclerViewAdapter extends RecyclerView.Adapter<VehiculoRecyclerViewAdapter.ViewHolder> {

    private final List<Vehiculo> mValues;

    public VehiculoRecyclerViewAdapter(List<Vehiculo> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentVehiculoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.text_carName.setText( holder.mItem.getMarca() + " " + holder.mItem.getModelo());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Vehiculo mItem;
        ImageView imgButton_delete;
        ImageView img_car;
        TextView text_carName;


        public ViewHolder(FragmentVehiculoBinding binding) {
            super(binding.getRoot());
            imgButton_delete = binding.imgButtonDelete;
            img_car = binding.imgCar;
            text_carName = binding.textNameCar;
        }
    }
}