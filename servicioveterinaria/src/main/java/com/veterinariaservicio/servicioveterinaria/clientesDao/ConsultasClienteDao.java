package com.veterinariaservicio.servicioveterinaria.clientesDao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veterinariaservicio.servicioveterinaria.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultasClienteDao {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public List<ClientesConsultaDTO> consultarClientes (int folioCtl, String telefonoCl, String nombreMst, String nombreClt){
        String sql = "SELECT folioCtl,nombreClt,nombreMst,telefonoCl,coloniaCl,calleCl,numeroCalleCl,municipioCl,email from fun_buscarCliente(?,?,?,?)";
        List<ClientesConsultaDTO> resultadoConsulta = jdbcTemplate.query(sql,new Object[]{folioCtl,telefonoCl, nombreMst,nombreClt},
                new BeanPropertyRowMapper<>(ClientesConsultaDTO.class)
        );
        return resultadoConsulta;
    }

    public int InsertarCliente(ClientesInsertDTO clientes) throws Exception {
        try {
            String sql = "select fun_insertarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return jdbcTemplate.queryForObject(sql, new Object[]{clientes.getCnombre(), clientes.getCapellido(),
                    clientes.getCcolonia(), clientes.getCcalle(), clientes.getCestado(),
                    clientes.getCemail(), clientes.getCtelefono(), clientes.getCnumeroCalle(),
                    clientes.getMnombre(), clientes.getFechaNacimiento(), clientes.getMedadAnio(), clientes.getMedadMes(), clientes.getMfechaDia(),
                    clientes.getMpesoMascota()}, Integer.class
            );
        }
        catch (Exception ex){
            throw new Exception("Error de acceso a la informacion", ex);
        }
    }

    public void updateClientes (ClientesDTO clientesDTO) throws JsonProcessingException, SQLException {


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(clientesDTO);
            String script = "select fun_updateclientes(?)";

            String result = jdbcTemplate.queryForObject(script, String.class, json);
        } catch (DataAccessException | JsonProcessingException e) {
            // Manejar la excepción

        }

    }

    public  void updateMascota (MascotaDTO mascotaDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMascota = objectMapper.writeValueAsString(mascotaDTO);
        String script = "select fun_updatemascota(?)";
        String result = jdbcTemplate.queryForObject(script, String.class,jsonMascota);
    }

    public void eliminarCliente(int folioCtl,int dltClientes, int dltMascota) throws Exception {
        try{
            String script = "select fun_eliminarClientes(?,?,?,?)";
            String result = jdbcTemplate.queryForObject(script,new Object[]{
                    folioCtl,
                    dltClientes,
                    dltMascota
            }, String.class);
        }catch (Exception ex){
            throw  new Exception("Error al ejecutar funcion delete",ex);
        }
    }

    public void insertarConsulta(String fecha,int servicio,int cliente ) throws Exception{
        try{
            String query = "SELECT fun_crearCitas(?,?,?)";
            jdbcTemplate.queryForObject(query,new Object[]{
                    cliente,
                    servicio,
                    fecha
            }, Integer.class);
        }
        catch(Exception ex){
            throw new Exception("ERROR AL INSERTAR CONSULTA",ex);
        }
    }

    public List<CitasDTO> consultarCitas(String fecha,int cliente) throws Exception{
        try{

            String query = "select nombreCl,apellidoCl,mascota,raza,concepto,fechaCita,telefonoCl,estatus from fun_concultarCitas(?,?)";
            List<CitasDTO>  resultadoConsulta =jdbcTemplate.query(query,new Object[]{
                    fecha,
                    cliente
            },new BeanPropertyRowMapper<>(CitasDTO.class));
            return resultadoConsulta;
        }
        catch(Exception ex){
            throw new Exception("ERROR AL CONSULTAR CITAS");
        }

    }



}
