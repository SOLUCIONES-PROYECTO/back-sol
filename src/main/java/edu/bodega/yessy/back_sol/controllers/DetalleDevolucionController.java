package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.bodega.yessy.back_sol.models.DetalleDevolucion;
import edu.bodega.yessy.back_sol.services.DetalleDevolucionService;

@RestController
@RequestMapping("/detalledevoluciones")
public class DetalleDevolucionController {

    @Autowired
    DetalleDevolucionService detalleDevolucionService;
    @GetMapping
    public ArrayList<DetalleDevolucion> listarDetalleDevoluciones() {
        return detalleDevolucionService.listar();
    }
    @PostMapping
    public DetalleDevolucion nuevoDetalleDevolucion(@RequestBody DetalleDevolucion detalleDevolucion) {
        return detalleDevolucionService.nuevo(detalleDevolucion);
    }
}