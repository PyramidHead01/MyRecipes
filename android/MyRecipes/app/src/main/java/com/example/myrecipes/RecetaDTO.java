package com.example.myrecipes;

public class RecetaDTO {

    String nombre;
    String descripcion;

    public RecetaDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
