package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.MetodoPago;
import edu.bodega.yessy.back_sol.services.MetodoPagoService;

@CrossOrigin(origins = "http://localhost:4200")
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