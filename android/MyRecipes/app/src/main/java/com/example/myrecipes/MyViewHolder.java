package com.example.myrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView nombreTV;
    private TextView descripcionTV;

    public MyViewHolder(View itemView) {
        super(itemView);

        nombreTV = itemView.findViewById(R.id.textNombre);
        descripcionTV = itemView.findViewById(R.id.textDescripcion);

    }

    public TextView getNombreTV() {
        return nombreTV;
    }

    public TextView getDescripcionTV() {
        return descripcionTV;
    }

}
