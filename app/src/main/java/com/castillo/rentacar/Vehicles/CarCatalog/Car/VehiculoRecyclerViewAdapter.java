package com.castillo.rentacar.Vehicles.CarCatalog.Car;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        holder.text_carName.setText( holder.mItem.getMarca() + " " + holder.mItem.getModelo());
        holder.text_carYear.setText(holder.mItem.getStatusCar().getNombre());
        holder.text_carDistance.setText(holder.mItem.getKilometraje() + " Km");

        holder.imgButton_delete.setOnClickListener(view -> {
            activity.rentCarManager.deleteCar(index_category, position, context);
            notifyDataSetChanged();
        });

        holder.touch_linear.setOnClickListener(v -> {
            activity.rentCarTools.openFragment(R.id.fragmentView, new RentCarFragment(position), activity.getSupportFragmentManager().beginTransaction());
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Vehiculo mItem;
        ImageView imgButton_delete;
        TextView text_carName;
        TextView text_carYear;
        TextView text_carDistance;
        LinearLayout touch_linear;


        public ViewHolder(FragmentVehiculoBinding binding) {
            super(binding.getRoot());
            imgButton_delete = binding.imgButtonDelete;
            text_carName = binding.textNameCar;
            text_carYear = binding.textYearCar;
            text_carDistance = binding.textDistanceCar;
            touch_linear = binding.touchLinear;
        }
    }
}