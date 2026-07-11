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

import edu.bodega.yessy.back_sol.dto.detalleusointerno.DetalleUsoInternoRequestDTO;
import edu.bodega.yessy.back_sol.dto.detalleusointerno.DetalleUsoInternoResponseDTO;
import edu.bodega.yessy.back_sol.services.DetalleUsoInternoService;

@RestController
@RequestMapping("/detalleusointernos")
public class DetalleUsoInternoController {

    @Autowired
    private DetalleUsoInternoService detalleUsoInternoService;

    @GetMapping
    public ArrayList<DetalleUsoInternoResponseDTO> listar() {
        return detalleUsoInternoService.listar();
    }

    @PostMapping
    public DetalleUsoInternoResponseDTO crear(@RequestBody DetalleUsoInternoRequestDTO dto) {
        return detalleUsoInternoService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public DetalleUsoInternoResponseDTO buscar(@PathVariable Integer id) {
        return detalleUsoInternoService.buscar(id);
    }

    @PutMapping("/{id}")
    public DetalleUsoInternoResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody DetalleUsoInternoRequestDTO dto) {

        return detalleUsoInternoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleUsoInternoService.eliminar(id);
    }
}