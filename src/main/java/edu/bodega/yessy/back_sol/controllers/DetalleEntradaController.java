package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.bodega.yessy.back_sol.models.DetalleEntrada;
import edu.bodega.yessy.back_sol.services.DetalleEntradaService;

@RestController
@RequestMapping("/detalleentradas")
public class DetalleEntradaController {

    @Autowired
    DetalleEntradaService detalleEntradaService;
    @GetMapping
    public ArrayList<DetalleEntrada> listarDetalleEntradas() {
        return detalleEntradaService.listar();
    }
    @PostMapping
    public DetalleEntrada nuevoDetalleEntrada(@RequestBody DetalleEntrada detalleEntrada) {
        return detalleEntradaService.nuevo(detalleEntrada);
    }
}