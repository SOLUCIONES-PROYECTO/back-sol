package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.models.TipoDocEntrada;
import edu.bodega.yessy.back_sol.services.TipoDocEntradaService;

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