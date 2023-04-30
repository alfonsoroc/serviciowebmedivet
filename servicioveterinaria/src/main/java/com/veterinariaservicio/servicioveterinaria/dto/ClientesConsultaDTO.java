package com.veterinariaservicio.servicioveterinaria.dto;

public class ClientesConsultaDTO {

    public int folioCtl;
    public String nombreClt;
    public String nombreMst;
    public String razaMst;
    public String fechaMst;
    public String MpesoMascota;
    public String telefonoCl;
    public String coloniaCl;
    public String calleCl;
    public int numeroCalleCl;
    public String municipioCl;
    public String email;

    public long getFolioCtl() {
        return folioCtl;
    }

    public void setFolioCtl(int folioCtl) {
        this.folioCtl = folioCtl;
    }

    public String getNombreClt() {
        return nombreClt;
    }

    public void setNombreClt(String nombreClt) {
        this.nombreClt = nombreClt;
    }

    public String getNombreMst() {
        return nombreMst;
    }

    public void setNombreMst(String nombreMst) {
        this.nombreMst = nombreMst;
    }

    public String getTelefonoCl() {
        return telefonoCl;
    }

    public void setTelefonoCl(String telefonoCl) {
        this.telefonoCl = telefonoCl;
    }

    public String getColoniaCl() {
        return coloniaCl;
    }

    public void setColoniaCl(String coloniaCl) {
        this.coloniaCl = coloniaCl;
    }

    public String getCalleCl() {
        return calleCl;
    }

    public void setCalleCl(String calleCl) {
        this.calleCl = calleCl;
    }

    public int getNumeroCalleCl() {
        return numeroCalleCl;
    }

    public void setNumeroCalleCl(int numeroCalleCl) {
        this.numeroCalleCl = numeroCalleCl;
    }

    public String getMunicipioCl() {
        return municipioCl;
    }

    public void setMunicipioCl(String municipioCl) {
        this.municipioCl = municipioCl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazaMst() {
        return razaMst;
    }

    public void setRazaMst(String razaMst) {
        this.razaMst = razaMst;
    }

    public String getFechaMst() {
        return fechaMst;
    }

    public void setFechaMst(String fechaMst) {
        this.fechaMst = fechaMst;
    }

    public String getMpesoMascota() {
        return MpesoMascota;
    }

    public void setMpesoMascota(String mpesoMascota) {
        MpesoMascota = mpesoMascota;
    }
}
