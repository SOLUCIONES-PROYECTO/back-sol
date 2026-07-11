package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.unidadmedida.UnidadMedidaRequestDTO;
import edu.bodega.yessy.back_sol.dto.unidadmedida.UnidadMedidaResponseDTO;
import edu.bodega.yessy.back_sol.services.UnidadMedidaService;

@RestController
@RequestMapping("/unidadmedidas")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaService unidadMedidaService;


    @GetMapping
    public ArrayList<UnidadMedidaResponseDTO> listar() {
        return unidadMedidaService.listar();
    }

    @PostMapping
    public UnidadMedidaResponseDTO crear(@RequestBody UnidadMedidaRequestDTO dto) {
        return unidadMedidaService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public UnidadMedidaResponseDTO buscar(@PathVariable Integer id) {
        return unidadMedidaService.buscar(id);
    }

    @PutMapping("/{id}")
    public UnidadMedidaResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody UnidadMedidaRequestDTO dto) {

        return unidadMedidaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        unidadMedidaService.eliminar(id);
    }
}