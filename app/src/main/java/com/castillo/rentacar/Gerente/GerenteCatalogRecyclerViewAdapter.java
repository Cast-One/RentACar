package com.castillo.rentacar.Gerente;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.castillo.rentacar.Models.Gerente;
import com.castillo.rentacar.databinding.FragmentGerenteCatalogBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class GerenteCatalogRecyclerViewAdapter extends RecyclerView.Adapter<GerenteCatalogRecyclerViewAdapter.ViewHolder> {

    private final List<Gerente> mValues;
    Context context;

    GerenteCatalogActivity activity;

    public GerenteCatalogRecyclerViewAdapter(List<Gerente> items, Context context) {
        mValues = items;
        this.context = context;

        activity = (GerenteCatalogActivity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentGerenteCatalogBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mItem = mValues.get(position);

        holder.textViewName.setText(holder.mItem.getNombre()+" "+holder.mItem.getMaterno()+" "+holder.mItem.getPaterno());
        holder.textViewGender.setText("Género: "+holder.mItem.getGenero() + "");
        holder.textViewCurp.setText(holder.mItem.getCurp());
        holder.textViewNumGerente.setText(holder.mItem.getNum_empleado());

        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String strDate = dateFormat.format(holder.mItem.getFecha_nacimiento());
        holder.textViewFechaNacimiento.setText(strDate);

        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.getRentCarManager().removeStaff(position, context);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textViewName;
        public final TextView textViewFechaNacimiento;
        public final TextView textViewGender;
        public final TextView textViewCurp;
        public final TextView textViewNumGerente;
        public final ImageView imageViewDelete;
        public Gerente mItem;

        public ViewHolder(FragmentGerenteCatalogBinding binding) {
            super(binding.getRoot());
            textViewName = binding.name;
            textViewFechaNacimiento = binding.fechaNacimiento;
            textViewGender = binding.generoUsuario;
            textViewCurp = binding.curp;
            textViewNumGerente = binding.numCliente;
            imageViewDelete = binding.buttonDelete;
        }

    }
}