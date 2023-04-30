package com.veterinariaservicio.servicioveterinaria.controller;

import com.veterinariaservicio.servicioveterinaria.clientesDao.VentasDAO;
import com.veterinariaservicio.servicioveterinaria.dto.BuscarProductoDTO;
import com.veterinariaservicio.servicioveterinaria.dto.ConsultarVentaDTO;
import com.veterinariaservicio.servicioveterinaria.dto.ProductosDTO;
import com.veterinariaservicio.servicioveterinaria.dto.VentasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class VentasController {
    @Autowired
    VentasDAO ventasDAO;

    @PostMapping("/guardar")
    public void guardarProducto (@RequestBody ProductosDTO productosDTO)throws Exception{
         ventasDAO.guardarProducto(productosDTO);
    }
    @PostMapping("/venta")
    public void ventaProducto(@RequestBody VentasDTO[] ventasDTO) throws Exception{
        ventasDAO.guardarVenta(ventasDTO);
    }

    @PutMapping("/actualizar")
    public void actualizarProducto(@RequestBody ProductosDTO productosDTO) throws Exception{
        ventasDAO.actualizarProductos(productosDTO);
    }

    @GetMapping("/buscar")
    public List<BuscarProductoDTO> buscarProductos(
            @RequestParam int codigo,
            @RequestParam String nombre) throws Exception{
        return ventasDAO.consultarProducto(codigo,nombre);
    }

    @DeleteMapping("/eliminar")
    public int eliminarCodigo (@RequestParam int codigo) throws Exception {
        return ventasDAO.eliminarCodigo(codigo);
    }

    @GetMapping("/buscar/venta")
    public List<ConsultarVentaDTO> consultarVenta(@RequestParam String fecha) throws Exception{
        return ventasDAO.consultarVenta(fecha);
    }

}
