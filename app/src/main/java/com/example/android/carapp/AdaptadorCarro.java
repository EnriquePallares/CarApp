package com.example.android.carapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCarro extends RecyclerView.Adapter<AdaptadorCarro.CarroViewHolder>{
    private ArrayList<Carro> carros;
    private Context contexto;

    public AdaptadorCarro(ArrayList<Carro> carros, Context contexto){
        this.carros = carros;
        this.contexto = contexto;
    }

    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carros, parent, false);

        return new CarroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {
        Carro c = carros.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.placa.setText(c.getPlaca());
        holder.marca.setText(contexto.getResources().getStringArray(R.array.marcas)[c.getMarca()]);
        holder.color.setText(contexto.getResources().getStringArray(R.array.colores)[c.getColor()]);
        holder.precio.setText("" + c.getPrecio());
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView marca;
        private TextView color;
        private TextView precio;
        private View v;

        public CarroViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            placa = v.findViewById(R.id.lblPlaca);
            marca = v.findViewById(R.id.lblMarca);
            color = v.findViewById(R.id.lblColor);
            precio = v.findViewById(R.id.lblPrecio);
        }
    }
}
