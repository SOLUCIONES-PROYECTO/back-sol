package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.EstadoIngreso;
import edu.bodega.yessy.back_sol.services.EstadoIngresoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estadoingresos")
public class EstadoIngresoController {

    @Autowired
    EstadoIngresoService estadoIngresoService;
    @GetMapping
    public ArrayList<EstadoIngreso> listarEstadoIngresos() {
        return estadoIngresoService.listar();
    }
    @PostMapping
    public EstadoIngreso nuevoEstadoIngreso(@RequestBody EstadoIngreso estadoIngreso) {
        return estadoIngresoService.nuevo(estadoIngreso);
    }
}