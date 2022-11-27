package com.castillo.rentacar;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.castillo.rentacar.placeholder.PlaceholderContent.PlaceholderItem;
import com.castillo.rentacar.databinding.FragmentVehiculoBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class VehiculoRecyclerViewAdapter extends RecyclerView.Adapter<VehiculoRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;

    public VehiculoRecyclerViewAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentVehiculoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public PlaceholderItem mItem;

        public ViewHolder(FragmentVehiculoBinding binding) {
            super(binding.getRoot());
        }
    }
}