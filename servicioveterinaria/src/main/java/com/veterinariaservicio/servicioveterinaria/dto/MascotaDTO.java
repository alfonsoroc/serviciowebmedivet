package com.veterinariaservicio.servicioveterinaria.dto;

public class MascotaDTO {
    public int fkcliente;
    public String nombreMascota;
    public int edadanio;
    public int edadmes;
    public float pesomascota;
    public String fechaNacimiento;
    public int fechadia;

    public String raza;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(int fkcliente) {
        this.fkcliente = fkcliente;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getEdadanio() {
        return edadanio;
    }

    public void setEdadanio(int edadanio) {
        this.edadanio = edadanio;
    }

    public int getEdadmes() {
        return edadmes;
    }

    public void setEdadmes(int edadmes) {
        this.edadmes = edadmes;
    }

    public float getPesomascota() {
        return pesomascota;
    }

    public void setPesomascota(float pesomascota) {
        this.pesomascota = pesomascota;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechadia() {
        return fechadia;
    }

    public void setFechadia(int fechadia) {
        this.fechadia = fechadia;
    }
}
