package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.EstadoProducto;
import edu.bodega.yessy.back_sol.services.EstadoProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estadoproductos")
public class EstadoProductoController {

    @Autowired
    EstadoProductoService estadoProductoService;
    @GetMapping
    public ArrayList<EstadoProducto> listarEstadoProductos() {
        return estadoProductoService.listar();
    }
    @PostMapping
    public EstadoProducto nuevoEstadoProducto(@RequestBody EstadoProducto estadoProducto) {
        return estadoProductoService.nuevo(estadoProducto);
    }
}