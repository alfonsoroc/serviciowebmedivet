package com.veterinariaservicio.servicioveterinaria.dto;

public class ProductosDTO {
    public int codigo;
    public String nombreproducto;
    public  float precio;
    public int cantidad;
    public int catproducto;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCatproducto() {
        return catproducto;
    }

    public void setCatproducto(int catproducto) {
        this.catproducto = catproducto;
    }
}
