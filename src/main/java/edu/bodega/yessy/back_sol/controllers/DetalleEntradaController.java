package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.detalleentrada.DetalleEntradaRequestDTO;
import edu.bodega.yessy.back_sol.dto.detalleentrada.DetalleEntradaResponseDTO;
import edu.bodega.yessy.back_sol.services.DetalleEntradaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detalle-entradas")
public class DetalleEntradaController {

    @Autowired
    private DetalleEntradaService detalleEntradaService;

    @GetMapping
    public ArrayList<DetalleEntradaResponseDTO> listar() {
        return detalleEntradaService.listar();
    }

    @PostMapping
    public DetalleEntradaResponseDTO nuevo(
            @RequestBody DetalleEntradaRequestDTO dto) {

        return detalleEntradaService.nuevo(dto);
    }


    @GetMapping("/{id}")
    public DetalleEntradaResponseDTO buscar(
            @PathVariable Integer id) {

        return detalleEntradaService.buscar(id);
    }

    @PutMapping("/{id}")
    public DetalleEntradaResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody DetalleEntradaRequestDTO dto) {

        return detalleEntradaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Integer id) {

        detalleEntradaService.eliminar(id);
    }
}