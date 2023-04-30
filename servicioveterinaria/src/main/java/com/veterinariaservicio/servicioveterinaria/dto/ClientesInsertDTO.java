package com.veterinariaservicio.servicioveterinaria.dto;

public class ClientesInsertDTO {
    public String Cnombre;
    public String Capellido;

    public String Ccolonia;

    public String getCcolonia() {
        return Ccolonia;
    }

    public void setCcolonia(String ccolonia) {
        Ccolonia = ccolonia;
    }

    public String Ccalle;
    public String Cestado;
    public String Cemail;
    public String Ctelefono;
    public int CnumeroCalle;
    public String Mnombre;

    public String fechaNacimiento;
    public int MedadAnio;
    public int MedadMes;
    public int MfechaDia;

    public  String Mraza;

    public  int folio;
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getMfechaDia() {
        return MfechaDia;
    }

    public void setMfechaDia(int mfechaDia) {
        MfechaDia = mfechaDia;
    }

    public float MpesoMascota;

    public String getCnombre() {
        return Cnombre;
    }

    public void setCnombre(String cnombre) {
        Cnombre = cnombre;
    }

    public String getCapellido() {
        return Capellido;
    }

    public void setCapellido(String capellido) {
        Capellido = capellido;
    }

    public String getCcalle() {
        return Ccalle;
    }

    public void setCcalle(String ccalle) {
        Ccalle = ccalle;
    }

    public String getCestado() {
        return Cestado;
    }

    public void setCestado(String cestado) {
        Cestado = cestado;
    }

    public String getCemail() {
        return Cemail;
    }

    public void setCemail(String cemail) {
        Cemail = cemail;
    }

    public String getCtelefono() {
        return Ctelefono;
    }

    public void setCtelefono(String ctelefono) {
        Ctelefono = ctelefono;
    }

    public int getCnumeroCalle() {
        return CnumeroCalle;
    }

    public void setCnumeroCalle(int cnumeroCalle) {
        CnumeroCalle = cnumeroCalle;
    }

    public String getMnombre() {
        return Mnombre;
    }

    public void setMnombre(String mnombre) {
        Mnombre = mnombre;
    }

    public int getMedadAnio() {
        return MedadAnio;
    }

    public void setMedadAnio(int medadAnio) {
        MedadAnio = medadAnio;
    }

    public int getMedadMes() {
        return MedadMes;
    }

    public void setMedadMes(int medadMes) {
        MedadMes = medadMes;
    }

    public float getMpesoMascota() {
        return MpesoMascota;
    }

    public void setMpesoMascota(float mpesoMascota) {
        MpesoMascota = mpesoMascota;
    }

    public String getMraza() {
        return Mraza;
    }

    public void setMraza(String mraza) {
        Mraza = mraza;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }
}
