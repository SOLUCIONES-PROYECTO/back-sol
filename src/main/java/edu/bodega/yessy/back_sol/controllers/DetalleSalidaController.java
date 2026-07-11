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

import edu.bodega.yessy.back_sol.dto.detallesalida.DetalleSalidaRequestDTO;
import edu.bodega.yessy.back_sol.dto.detallesalida.DetalleSalidaResponseDTO;
import edu.bodega.yessy.back_sol.services.DetalleSalidaService;

@RestController
@RequestMapping("/detallesalidas")
public class DetalleSalidaController {

    @Autowired
    private DetalleSalidaService detalleSalidaService;

    @GetMapping
    public ArrayList<DetalleSalidaResponseDTO> listar() {
        return detalleSalidaService.listar();
    }

    @PostMapping
    public DetalleSalidaResponseDTO crear(@RequestBody DetalleSalidaRequestDTO dto) {
        return detalleSalidaService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public DetalleSalidaResponseDTO buscar(@PathVariable Integer id) {
        return detalleSalidaService.buscar(id);
    }

    @PutMapping("/{id}")
    public DetalleSalidaResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody DetalleSalidaRequestDTO dto) {

        return detalleSalidaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleSalidaService.eliminar(id);
    }
}