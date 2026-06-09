package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.Proveedor;
import edu.bodega.yessy.back_sol.services.ProveedorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping
    public ArrayList<Proveedor> listarProveedores() {
        return proveedorService.listar();
    }

    @PostMapping
    public Proveedor nuevoProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.nuevo(proveedor);
    }
}
