package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.bodega.yessy.back_sol.models.DetalleSalida;
import edu.bodega.yessy.back_sol.services.DetalleSalidaService;

@RestController
@RequestMapping("/detallesalidas")
public class DetalleSalidaController {

    @Autowired
    DetalleSalidaService detalleSalidaService;
    @GetMapping
    public ArrayList<DetalleSalida> listarDetalleSalidas() {
        return detalleSalidaService.listar();
    }
    @PostMapping
    public DetalleSalida nuevoDetalleSalida(@RequestBody DetalleSalida detalleSalida) {
        return detalleSalidaService.nuevo(detalleSalida);
    }
}