package com.castillo.rentacar.Clients;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.castillo.rentacar.Models.Cliente;
import com.castillo.rentacar.databinding.FragmentClientsBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class ClientesCatalogoRecyclerViewAdapter extends RecyclerView.Adapter<ClientesCatalogoRecyclerViewAdapter.ViewHolder> {

    private final List<Cliente> mValues;
    ClientesCatalaogActivity activity;
    Context context;

    public ClientesCatalogoRecyclerViewAdapter(List<Cliente> items, Context context) {
        this.context = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        activity = (ClientesCatalaogActivity) context;
        return new ViewHolder(FragmentClientsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mItem = mValues.get(position);

        holder.textViewName.setText(holder.mItem.getNombre()+" "+holder.mItem.getMaterno()+" "+holder.mItem.getPaterno());
        holder.textViewGender.setText("Género: "+holder.mItem.getGenero() + "");
        holder.textViewCurp.setText(holder.mItem.getCurp());
        holder.textViewNumCliente.setText(holder.mItem.getNum_cliente());

        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String strDate = dateFormat.format(holder.mItem.getFecha_nacimiento());
        holder.textViewFechaNacimiento.setText(strDate);

        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.getRentCarManager().removeClient(position, context);
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
        public final TextView textViewNumCliente;
        public final ImageView imageViewDelete;

        public Cliente mItem;

        public ViewHolder(FragmentClientsBinding binding) {
            super(binding.getRoot());
            textViewName = binding.name;
            textViewFechaNacimiento = binding.fechaNacimiento;
            textViewGender = binding.generoUsuario;
            textViewCurp = binding.curp;
            textViewNumCliente = binding.numCliente;
            imageViewDelete = binding.buttonDelete;
        }

    }
}