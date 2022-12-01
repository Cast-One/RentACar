package com.castillo.rentacar.Renta;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.castillo.rentacar.Models.Renta;
import com.castillo.rentacar.databinding.FragmentActiveRentsBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Renta}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ActiveRentsRecyclerViewAdapter extends RecyclerView.Adapter<ActiveRentsRecyclerViewAdapter.ViewHolder> {

    private final List<Renta> mValues;
    Context context;

    public ActiveRentsRecyclerViewAdapter(List<Renta> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentActiveRentsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Renta mItem;

        public ViewHolder(FragmentActiveRentsBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

    }
}