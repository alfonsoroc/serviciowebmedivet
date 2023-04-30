package com.veterinariaservicio.servicioveterinaria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veterinariaservicio.servicioveterinaria.clientesDao.VentasDAO;
import com.veterinariaservicio.servicioveterinaria.dto.BuscarProductoDTO;
import com.veterinariaservicio.servicioveterinaria.dto.ConsultarVentaDTO;
import com.veterinariaservicio.servicioveterinaria.dto.ProductosDTO;
import com.veterinariaservicio.servicioveterinaria.dto.VentasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import java.sql.ClientInfoStatus;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VentasDaoImpl extends VentasDAO {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public void guardarProducto (ProductosDTO productosDTO) throws Exception {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(productosDTO);
            String query = "SELECT fun_guardarProducto(cast(? as json))";
            jdbcTemplate.queryForObject(query,String.class,json);
        }
        catch (Exception ex){
            throw  new Exception("Error al insertar Producto",ex);
        }

    }

    @Override
    public void guardarVenta (VentasDTO[] ventasDTO) throws Exception{
        LocalDate fechaActual = LocalDate.now();
        try{
            List <VentasDTO>  ventas = new ArrayList<>();
            for(VentasDTO ventas1:ventasDTO){
             String  fechaServ = ventas1.getFecha();
                if (fechaServ == "") {
                    ventas1.setFecha(String.valueOf(fechaActual));
                }
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(ventasDTO);
            String query = "SELECT fun_guardarVentas(cast(? as json)) ";
            jdbcTemplate.queryForObject(query, String.class,json);
        }
        catch (Exception ex){
            throw  new Exception("Error al insertar Producto",ex);
        }
    }

    @Override
    public void actualizarProductos (ProductosDTO productosDTO) throws Exception {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(productosDTO);
            String query = "SELECT fun_actualizarProducto(cast(? as json))";
            jdbcTemplate.queryForObject(query, String.class,json);

        }
        catch(Exception ex){
            throw new Exception("Error al actualizar Producto",ex);
        }
    }

    @Override
    public List<BuscarProductoDTO>consultarProducto(int codigo, String nombre)throws Exception{
        try{
            String query ="SELECT id_producto,codigo,nombre,precio_producto,cantidad_producto,tipo_producto from fun_buscarProducto(?,?)";

            List<BuscarProductoDTO> resultado = jdbcTemplate.query(query,new Object[]{codigo,nombre},new BeanPropertyRowMapper<>(BuscarProductoDTO.class));
            return resultado;
        }
        catch (Exception ex){
            throw new Exception("Error al buscar producto",ex);

        }

    }

    

    public int eliminarCodigo(int codigo) throws Exception{
        try{
            String query = "SELECT fun_eliminarProducto(?)";
            jdbcTemplate.queryForObject(query,new Object[]{
                    codigo
            },String.class);
        }
        catch (Exception ex){


        }
        return codigo;
    }

    public List<ConsultarVentaDTO> consultarVenta(String fecha)throws Exception{
        try{
            String query = "SELECT nombrep,codigop,precio,cantidad,total from fun_consultarventas(?::varchar)";
            Object[] parametros = new Object[]{fecha};
            List<ConsultarVentaDTO> resultado = jdbcTemplate.query(query,parametros,new BeanPropertyRowMapper<>(ConsultarVentaDTO.class));
            return resultado;
        }
        catch (Exception ex){
            throw new Exception("ERROR AL CONSULTAR VENTAS",ex);
        }

    }


}
