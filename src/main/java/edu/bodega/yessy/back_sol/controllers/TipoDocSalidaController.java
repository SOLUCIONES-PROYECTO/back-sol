package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.TipoDocSalida;
import edu.bodega.yessy.back_sol.services.TipoDocSalidaService;

@CrossOrigin(origins = "http://localhost:4200")
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