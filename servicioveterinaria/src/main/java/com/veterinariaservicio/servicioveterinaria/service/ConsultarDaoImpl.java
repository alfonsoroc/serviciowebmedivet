package com.veterinariaservicio.servicioveterinaria.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veterinariaservicio.servicioveterinaria.clientesDao.ConsultasClienteDao;
import com.veterinariaservicio.servicioveterinaria.configuracion.CalcularFechas;
import com.veterinariaservicio.servicioveterinaria.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ConsultarDaoImpl extends ConsultasClienteDao {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public List<ClientesConsultaDTO> consultarClientes(int folioCtl, String telefonoCl, String nombreMst, String nombreClt) {
        String sql = "SELECT folioCtl,nombreClt,nombreMst,razaMst,fechaMst,MpesoMascota,telefonoCl,coloniaCl,calleCl,numeroCalleCl,municipioCl,email from fun_buscarCliente(?,?,?,?)";
        List<ClientesConsultaDTO> resultadoConsulta = jdbcTemplate.query(sql, new Object[]{folioCtl, telefonoCl, nombreMst, nombreClt}, new BeanPropertyRowMapper<>(ClientesConsultaDTO.class));

        return resultadoConsulta;
    }
    @Override
    public int InsertarCliente(ClientesInsertDTO clientes) throws Exception {

        int result = 0;
        if(clientes.getFechaNacimiento()!=""){
            CalcularFechas calcularFechas = new CalcularFechas();
            List<Integer> listaFecha = new ArrayList<Integer>();
            listaFecha = calcularFechas.calcularFechaEdad(clientes.getFechaNacimiento());
            clientes.setMedadMes(listaFecha.get(0));
            clientes.setMfechaDia(listaFecha.get(1));
            clientes.setMedadAnio(listaFecha.get(2));
        }
    try {
        String sql = "select fun_insertarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        result = jdbcTemplate.queryForObject(sql, new Object[]{clientes.getCnombre(), clientes.getCapellido(),
                clientes.getCcolonia(), clientes.getCcalle(), clientes.getCestado(),
                clientes.getCemail(), clientes.getCtelefono(), clientes.getCnumeroCalle(),
                clientes.getMnombre(), clientes.getFechaNacimiento(), clientes.getMedadAnio(), clientes.getMedadMes(), clientes.getMfechaDia(),
                clientes.getMpesoMascota(), clientes.getMraza(), clientes.getFolio()}, Integer.class
        );
    }
    catch(Exception ex){
       throw new Exception ("Error al acceder a la fuente de datos", ex) ;

    }
       return result;
    }

    @Override
    public void updateClientes(ClientesDTO clientesDTO) throws JsonProcessingException, SQLException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(clientesDTO);

            String script = "select fun_updateclientes(cast(? as json))";
            jdbcTemplate.update(script, new Object[] {json}, new int[] {Types.OTHER});
        } catch (DataAccessException | JsonProcessingException e) {
            // Manejar la excepción
        }
    }

    @Override
    public void updateMascota (MascotaDTO mascotaDTO){
        CalcularFechas calcularFechas = new CalcularFechas();
        List<Integer> listaFecha = new ArrayList<Integer>();
        listaFecha = calcularFechas.calcularFechaEdad(mascotaDTO.getFechaNacimiento());
        mascotaDTO.setEdadmes(listaFecha.get(0));
        mascotaDTO.setFechadia(listaFecha.get(1));
        mascotaDTO.setEdadanio(listaFecha.get(2));

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(mascotaDTO);

            String script = "select fun_updatemascota(cast(? as json))";
            jdbcTemplate.update(script, new Object[] {json}, new int[] {Types.OTHER});
        } catch (DataAccessException | JsonProcessingException e) {
            // Manejar la excepción
        }

    }

    @Override
    public void eliminarCliente(int folioCtl,int dltClientes, int dltMascota) throws Exception {
        try{
            String script = "select fun_eliminarClientes(?,?,?)";
            String result = jdbcTemplate.queryForObject(script,new Object[]{
                    folioCtl,
                    dltClientes,
                    dltMascota
            }, String.class);
        }catch (Exception ex){
            throw  new Exception("Error al ejecutar funcion delete",ex);
        }
    }

    @Override
    public void insertarConsulta(String fecha,int servicio,int cliente ) throws Exception{
        try{
            String query = "SELECT fun_crearCitas(?,?,?)";
            jdbcTemplate.queryForObject(query,new Object[]{
                    cliente,
                    servicio,
                    fecha
            }, String.class);
        }
        catch(Exception ex){
            throw new Exception("ERROR AL INSERTAR CONSULTA",ex);
        }
    }

    @Override
    public List<CitasDTO> consultarCitas(String fecha, int cliente) throws Exception{
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
