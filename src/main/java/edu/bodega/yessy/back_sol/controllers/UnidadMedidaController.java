package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.bodega.yessy.back_sol.models.UnidadMedida;
import edu.bodega.yessy.back_sol.services.UnidadMedidaService;

@RestController
@RequestMapping("/unidadmedidas")
public class UnidadMedidaController {

    @Autowired
    UnidadMedidaService unidadMedidaService;
    @GetMapping
    public ArrayList<UnidadMedida> listarUnidadMedidas() {
        return unidadMedidaService.listar();
    }
    @PostMapping
    public UnidadMedida nuevaUnidadMedida(@RequestBody UnidadMedida unidadMedida) {
        return unidadMedidaService.nuevo(unidadMedida);
    }
    
}