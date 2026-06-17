package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.DetalleNea;
import edu.bodega.yessy.back_sol.services.DetalleNeaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detallenea")
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