package com.veterinariaservicio.servicioveterinaria.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.veterinariaservicio.servicioveterinaria.clientesDao.ConsultasClienteDao;
import com.veterinariaservicio.servicioveterinaria.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    protected ConsultasClienteDao consultarDao;


    @GetMapping("/buscar/clientes")
    public List<ClientesConsultaDTO> BuscarClientes (
            @RequestParam int folioCliente,
            @RequestParam  String telefonoCliente,
            @RequestParam String nombreMsta,
            @RequestParam String nombreCliente

    ){
        return consultarDao.consultarClientes(folioCliente,telefonoCliente,nombreMsta,nombreCliente);
    }

    @PostMapping("/insertar/clientes")
    public int InsertarCliente(@RequestBody ClientesInsertDTO clientesDTO) throws Exception {
        try{
       return consultarDao.InsertarCliente(clientesDTO);}
        catch (Exception ex ){
            throw  new Exception("Error al ingresar la informacion",ex);
        }

    }
    @PutMapping("/actualizar/clientes")
    public void actualizarClientes(@RequestBody ClientesDTO clientesDTO) throws SQLException, JsonProcessingException {
        consultarDao.updateClientes(clientesDTO);

    }

    @PutMapping("/actualizar/mascota")
    public void actualizarMascota(@RequestBody MascotaDTO mascotaDTO) throws JsonProcessingException {
        consultarDao.updateMascota(mascotaDTO);
    }

    @DeleteMapping("/eliminar")
    public void eliminarCliente(
            @RequestParam int folioCtl,
            @RequestParam int dltCliente,
            @RequestParam int dltMascota
    ) throws Exception {

        consultarDao.eliminarCliente(folioCtl,dltCliente,dltMascota);
    }

    @PostMapping("/insertar/consulta")
    public void insertarConsulta (@RequestParam int cliente,@RequestParam int servicio,@RequestParam String fecha) throws Exception{
        consultarDao.insertarConsulta(fecha,servicio,cliente);
    }
    @GetMapping("/buscar/cita")
    public List<CitasDTO> consultarCita (@RequestParam String fecha,@RequestParam int cliente) throws Exception{
        return consultarDao.consultarCitas(fecha, cliente);
    }

}
