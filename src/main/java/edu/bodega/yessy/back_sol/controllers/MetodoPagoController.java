package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.models.MetodoPago;
import edu.bodega.yessy.back_sol.services.MetodoPagoService;

@RestController
@RequestMapping("/metodospago")
public class MetodoPagoController {

    @Autowired
    MetodoPagoService metodoPagoService;
    @GetMapping
    public ArrayList<MetodoPago> listarMetodosPago() {
        return metodoPagoService.listar();
    }
    @PostMapping
    public MetodoPago nuevoMetodoPago(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.nuevo(metodoPago);
    }
}