package com.castillo.rentacar.Vehicles.CarCatalog;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.castillo.rentacar.Models.CategoriaVehiculo;
import com.castillo.rentacar.R;
import com.castillo.rentacar.Vehicles.CarCatalog.Car.CarsModelsActivity;
import com.castillo.rentacar.databinding.FragmentCategoryBinding;

import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    CarsCatalogActivity activity;
    Context context;
    private final List<CategoriaVehiculo> mValues;

    public CategoryRecyclerViewAdapter(Context context, List<CategoriaVehiculo> items) {
        this.context = context;
        mValues = items;
        activity = (CarsCatalogActivity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.text_CategoryName.setText(holder.mItem.getEnum_tipo_auto().getNombre());

        holder.linearLayoutContainer.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(context, CarsModelsActivity.class);
            bundle.putInt("index_category", position);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        });

        getImageByPosition(holder.image_category, position);
    }

    private void getImageByPosition(ImageView imageView, int position) {

        switch (position){
            case 0:
                imageView.setImageResource(R.drawable.ic_car_hatchback);
                break;
            case 1:
                imageView.setImageResource(R.drawable.ic_car_sedan);
                break;
            case 2:
                imageView.setImageResource(R.drawable.ic_car_camioneta);
                break;
            case 3:
                imageView.setImageResource(R.drawable.ic_car_pickup);
                break;
            default:
                imageView.setImageResource(R.drawable.img_car_gray);
        }

    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CategoriaVehiculo mItem;
        TextView text_CategoryName;
        LinearLayout linearLayoutContainer;
        ImageView image_category;

        public ViewHolder(FragmentCategoryBinding binding) {
            super(binding.getRoot());
            text_CategoryName = binding.textCategoryName;
            image_category = binding.imageBg;
            linearLayoutContainer = binding.viewContainer;
        }

    }
}