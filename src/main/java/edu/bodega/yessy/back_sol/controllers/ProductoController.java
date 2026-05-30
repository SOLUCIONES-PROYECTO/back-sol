package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.services.ProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping
    public ArrayList<Producto> listarProductos(){
        return productoService.listar();
    }

    @PostMapping
    public Producto nuevoProducto(@RequestBody Producto producto){
        return productoService.nuevo(producto);
    }
}
