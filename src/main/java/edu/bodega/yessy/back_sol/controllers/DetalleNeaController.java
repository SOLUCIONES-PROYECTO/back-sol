package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.bodega.yessy.back_sol.models.DetalleNea;
import edu.bodega.yessy.back_sol.services.DetalleNeaService;

@RestController
@RequestMapping("/detalleneas")
public class DetalleNeaController {

    @Autowired
    DetalleNeaService detalleNeaService;
    @GetMapping
    public ArrayList<DetalleNea> listarDetalleNeas() {
        return detalleNeaService.listar();
    }
    @PostMapping
    public DetalleNea nuevoDetalleNea(@RequestBody DetalleNea detalleNea) {
        return detalleNeaService.nuevo(detalleNea);
    }
}