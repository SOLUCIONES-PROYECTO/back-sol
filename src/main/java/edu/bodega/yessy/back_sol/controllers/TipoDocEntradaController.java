package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.TipoDocEntrada;
import edu.bodega.yessy.back_sol.services.TipoDocEntradaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipodocentradas")
public class TipoDocEntradaController {

    @Autowired
    TipoDocEntradaService tipoDocEntradaService;
    @GetMapping
    public ArrayList<TipoDocEntrada> listarTipoDocEntradas() {
        return tipoDocEntradaService.listar();
    }
    @PostMapping
    public TipoDocEntrada nuevoTipoDocEntrada(@RequestBody TipoDocEntrada tipoDocEntrada) {
        return tipoDocEntradaService.nuevo(tipoDocEntrada);
    }
}