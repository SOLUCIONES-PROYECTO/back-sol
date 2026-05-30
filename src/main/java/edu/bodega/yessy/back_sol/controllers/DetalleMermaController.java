package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.bodega.yessy.back_sol.models.DetalleMerma;
import edu.bodega.yessy.back_sol.services.DetalleMermaService;

@RestController
@RequestMapping("/detallemermas")
public class DetalleMermaController {

    @Autowired
    DetalleMermaService detalleMermaService;
    @GetMapping
    public ArrayList<DetalleMerma> listarDetalleMermas() {
        return detalleMermaService.listar();
    }
    @PostMapping
    public DetalleMerma nuevoDetalleMerma(@RequestBody DetalleMerma detalleMerma) {
        return detalleMermaService.nuevo(detalleMerma);
    }
}