package com.veterinariaservicio.servicioveterinaria.clientesDao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veterinariaservicio.servicioveterinaria.dto.BuscarProductoDTO;
import com.veterinariaservicio.servicioveterinaria.dto.ConsultarVentaDTO;
import com.veterinariaservicio.servicioveterinaria.dto.ProductosDTO;
import com.veterinariaservicio.servicioveterinaria.dto.VentasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
import java.util.List;

public class VentasDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void guardarProducto (ProductosDTO productosDTO) throws Exception {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(productosDTO);
            String query = "fun_guardarProducto(cast(? as json))";
            jdbcTemplate.queryForObject(query,String.class,json);
        }
        catch (Exception ex){
            throw  new Exception("Error al insertar Producto",ex);
        }



    }

    public void guardarVenta (VentasDTO[] ventasDTO) throws Exception{
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(ventasDTO);
            String query = "SELECT fun_guardarVentas(cast(? as json)) ";
            jdbcTemplate.queryForObject(query, String.class,json);
        }
        catch (Exception ex){
            throw  new Exception("Error al insertar Producto",ex);
        }
    }

    public void actualizarProductos (ProductosDTO productosDTO) throws Exception {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(productosDTO);
            String query = "SELECT fun_actualizarProducto";
            jdbcTemplate.queryForObject(query, String.class,json);

        }
        catch(Exception ex){
            throw new Exception("Error al actualizar Producto",ex);
        }
    }

    public List<BuscarProductoDTO>consultarProducto(int codigo, String nombre)throws Exception{
        try{
            String query = "SELECT id_producto,codigo,nombre,precio_producto,cantidad_producto,tipo_producto from fun_buscarProducto";
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
        String query = "SELECT nombrep,codigop,precio,cantidad,total from fun_consultarventas(?)";
        List<ConsultarVentaDTO> resultado = jdbcTemplate.query(query,new Object[]{
                fecha
        },new BeanPropertyRowMapper<>(ConsultarVentaDTO.class));
            return resultado;
        }
        catch (Exception ex){
            throw new Exception("ERROR AL CONSULTAR VENTAS",ex);
        }

    }

}
