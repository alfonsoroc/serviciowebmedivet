package com.veterinariaservicio.servicioveterinaria.configuracion;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CalcularFechas{

    public List<Integer> calcularFechaEdad (String fechaNacimiento){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaCliente = LocalDate.parse(fechaNacimiento);
        Period periodo = Period.between(fechaCliente, fechaActual);
        int aniosDeDiferencia = periodo.getYears();
        long diasDeDiferencia = ChronoUnit.DAYS.between(fechaActual, fechaCliente);
        int totaldiasDiferencia = Math.toIntExact(diasDeDiferencia);
        int mesesDeDiferencia = fechaActual.getMonthValue() - fechaCliente.getMonthValue()
                + (fechaActual.getYear() - fechaCliente.getYear()) * 12;

        if(aniosDeDiferencia < 1){
           aniosDeDiferencia = aniosDeDiferencia *(-1);
        }
        if(totaldiasDiferencia < 1){
            totaldiasDiferencia =totaldiasDiferencia *(-1);
        }
        if(mesesDeDiferencia < 1){
            mesesDeDiferencia = mesesDeDiferencia*(-1);
        }

        List<Integer> listaFecha = new ArrayList<Integer>();
        listaFecha.add(mesesDeDiferencia);
        listaFecha.add(totaldiasDiferencia);
        listaFecha.add(aniosDeDiferencia);
        return listaFecha;
    }


}
