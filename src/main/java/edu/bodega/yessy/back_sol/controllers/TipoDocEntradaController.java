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

import edu.bodega.yessy.back_sol.dto.tipodocentrada.TipoDocEntradaRequestDTO;
import edu.bodega.yessy.back_sol.dto.tipodocentrada.TipoDocEntradaResponseDTO;
import edu.bodega.yessy.back_sol.services.TipoDocEntradaService;

@RestController
@RequestMapping("/tipodocentradas")
public class TipoDocEntradaController {

    @Autowired
    private TipoDocEntradaService tipoDocEntradaService;

    @GetMapping
    public ArrayList<TipoDocEntradaResponseDTO> listar() {
        return tipoDocEntradaService.listar();
    }

    @PostMapping
    public TipoDocEntradaResponseDTO crear(@RequestBody TipoDocEntradaRequestDTO dto) {
        return tipoDocEntradaService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public TipoDocEntradaResponseDTO buscar(@PathVariable Integer id) {
        return tipoDocEntradaService.buscar(id);
    }

    @PutMapping("/{id}")
    public TipoDocEntradaResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody TipoDocEntradaRequestDTO dto) {

        return tipoDocEntradaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        tipoDocEntradaService.eliminar(id);
    }
}