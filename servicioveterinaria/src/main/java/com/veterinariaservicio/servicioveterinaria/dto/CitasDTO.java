package com.veterinariaservicio.servicioveterinaria.dto;

public class CitasDTO {
    public String nombreCl;
    public String apellidoCl;
    public String mascota;

    public String raza;
    public String concepto;
    public String fechaCita;
    public String telefonoCl;
    public String estatus;


    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombreCl() {
        return nombreCl;
    }

    public void setNombreCl(String nombreCl) {
        this.nombreCl = nombreCl;
    }

    public String getApellidoCl() {
        return apellidoCl;
    }

    public void setApellidoCl(String apellidoCl) {
        this.apellidoCl = apellidoCl;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getTelefonoCl() {
        return telefonoCl;
    }

    public void setTelefonoCl(String telefonoCl) {
        this.telefonoCl = telefonoCl;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
