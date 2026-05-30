package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.models.EstadoPago;
import edu.bodega.yessy.back_sol.services.EstadoPagoService;

@RestController
@RequestMapping("/estadopagos")
public class EstadoPagoController {

    @Autowired
    EstadoPagoService estadoPagoService;
    @GetMapping
    public ArrayList<EstadoPago> listarEstadoPagos() {
        return estadoPagoService.listar();
    }
    @PostMapping
    public EstadoPago nuevoEstadoPago(@RequestBody EstadoPago estadoPago) {
        return estadoPagoService.nuevo(estadoPago);
    }
}