package com.veterinariaservicio.servicioveterinaria.configuracion;

import com.veterinariaservicio.servicioveterinaria.clientesDao.ConsultasClienteDao;
import com.veterinariaservicio.servicioveterinaria.clientesDao.VentasDAO;
import com.veterinariaservicio.servicioveterinaria.service.ConsultarDaoImpl;
import com.veterinariaservicio.servicioveterinaria.service.VentasDaoImpl;
import org.springframework.context.annotation.Bean;

public class MyConfig {
    @Bean
    public ConsultasClienteDao consultarDao() {
        return new ConsultarDaoImpl();
    }

    @Bean
    public VentasDAO ventasDAO(){return new VentasDaoImpl();}

}
