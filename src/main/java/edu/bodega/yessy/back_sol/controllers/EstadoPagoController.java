package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.EstadoPago;
import edu.bodega.yessy.back_sol.services.EstadoPagoService;

@CrossOrigin(origins = "http://localhost:4200")
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