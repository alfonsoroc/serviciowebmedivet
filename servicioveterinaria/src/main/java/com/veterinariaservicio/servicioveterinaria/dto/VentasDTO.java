package com.veterinariaservicio.servicioveterinaria.dto;

public class VentasDTO {
    public int fkproductos;
    public int fkservicio;
    public int cantidad;
    public String fecha;

    public float precio;

    public int getFkproductos() {
        return fkproductos;
    }

    public void setFkproductos(int fkproductos) {
        this.fkproductos = fkproductos;
    }

    public int getFkservicio() {
        return fkservicio;
    }

    public void setFkservicio(int fkservicio) {
        this.fkservicio = fkservicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
