package com.example.myrecipes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<RecetaDTO> listaRecetas;
    private Context context;

    private TextView nombreTV;
    private TextView descripcionTV;

    public MyRecyclerViewAdapter(List listaRecetas, Context context){
        this.listaRecetas = listaRecetas;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        nombreTV = holder.getNombreTV();
        descripcionTV = holder.getDescripcionTV();

        String name = listaRecetas.get(position).getNombre();
        String description = listaRecetas.get(position).getDescripcion();

        nombreTV.setText(name);
        descripcionTV.setText(description);

    }

    @Override
    public int getItemCount() {
        return listaRecetas.size();
    }
}
