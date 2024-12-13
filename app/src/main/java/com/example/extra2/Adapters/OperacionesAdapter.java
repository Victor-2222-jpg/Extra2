package com.example.extra2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.extra2.Models.Operaciones;
import com.example.extra2.R;
import com.example.extra2.View.DetalleOperaciones;
import com.example.extra2.ViewModels.OperacionesViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OperacionesAdapter extends RecyclerView.Adapter<OperacionesAdapter.OperacionesHolder> {

    private List<Operaciones> listasOperaciones;
    private Context context;

    public OperacionesAdapter(List<Operaciones> listasOperaciones, OperacionesViewModel operacionesViewModel) {
        this.listasOperaciones = listasOperaciones;
    }

    @NonNull
    @Override
    public OperacionesAdapter.OperacionesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly = LayoutInflater.from(parent.getContext());
        View vistaOperaciones = ly.inflate(R.layout.itemoperacion, parent, false);
        return new OperacionesHolder(vistaOperaciones);
    }

    @Override
    public void onBindViewHolder(@NonNull OperacionesAdapter.OperacionesHolder holder, int position) {
        Operaciones operaciones = listasOperaciones.get(position);
        holder.setData(operaciones);
    }

    @Override
    public int getItemCount() {
        return listasOperaciones != null ? listasOperaciones.size() : 0;
    }

    public void updateOperacionesList(List<Operaciones> nuevasOperaciones) {
        this.listasOperaciones = nuevasOperaciones;
        notifyDataSetChanged();
    }

    public class OperacionesHolder extends RecyclerView.ViewHolder {

        TextView Nombre;
        EditText Numero1, Numero2;
        ImageView imgOperaciones;

        public OperacionesHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            Nombre = itemView.findViewById(R.id.txtNombre);
            Numero1 = itemView.findViewById(R.id.txt);
            Numero2 = itemView.findViewById(R.id.txt2);
            imgOperaciones = itemView.findViewById(R.id.imgOp);
        }

        public void setData(Operaciones operaciones) {
            Nombre.setText(operaciones.getOperacion());
            Numero1.setText(String.valueOf(operaciones.getNum1()));
            Numero2.setText(String.valueOf(operaciones.getNum2()));

            imgOperaciones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String num1 = Numero1.getText().toString();
                    String num2 = Numero2.getText().toString();

                    Integer numero1 = Integer.parseInt(num1);
                    Integer numero2 = Integer.parseInt(num2);

                    operaciones.setNum1(numero1);
                    operaciones.setNum2(numero2);

                    Intent intent = new Intent(context, DetalleOperaciones.class);
                    intent.putExtra("operaciones", operaciones);
                    context.startActivity(intent);
                }
            });

            Picasso.get().load(operaciones.getImg()).into(imgOperaciones);
        }
    }
}