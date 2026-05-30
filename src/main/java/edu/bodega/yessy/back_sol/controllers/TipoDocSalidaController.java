package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.models.TipoDocSalida;
import edu.bodega.yessy.back_sol.services.TipoDocSalidaService;

@RestController
@RequestMapping("/tipodocsalidas")
public class TipoDocSalidaController {

    @Autowired
    TipoDocSalidaService tipoDocSalidaService;
    @GetMapping
    public ArrayList<TipoDocSalida> listarTipoDocSalidas() {
        return tipoDocSalidaService.listar();
    }
    @PostMapping
    public TipoDocSalida nuevoTipoDocSalida(@RequestBody TipoDocSalida tipoDocSalida) {
        return tipoDocSalidaService.nuevo(tipoDocSalida);
    }
}