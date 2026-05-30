package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.MetodoPago;
import edu.bodega.yessy.back_sol.services.MetodoPagoService;

@RestController
@RequestMapping("/metodosdepago")
public class MetodoDePagoController {

    @Autowired
    MetodoPagoService metodoPagoService;

    @GetMapping
    public ArrayList<MetodoPago> listarMetodoDePagos(){
        return metodoPagoService.listar();
    }

    @PostMapping
    public MetodoPago nuevoMetodoDePago(@RequestBody MetodoPago metodoDePago){
        return metodoPagoService.nuevo(metodoDePago);
    }
}
