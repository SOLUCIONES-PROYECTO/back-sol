package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.models.DetalleUsoInterno;
import edu.bodega.yessy.back_sol.services.DetalleUsoInternoService;

@RestController
@RequestMapping("/detalleusointernos")
public class DetalleUsoInternoController {

    @Autowired
    DetalleUsoInternoService detalleUsoInternoService;
    @GetMapping
    public ArrayList<DetalleUsoInterno> listarDetalleUsoInternos() {
        return detalleUsoInternoService.listar();
    }
    @PostMapping
    public DetalleUsoInterno nuevoDetalleUsoInterno(@RequestBody DetalleUsoInterno detalleUsoInterno) {
        return detalleUsoInternoService.nuevo(detalleUsoInterno);
    }
}