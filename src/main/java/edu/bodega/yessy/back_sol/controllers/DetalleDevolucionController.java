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

import edu.bodega.yessy.back_sol.dto.detalledevolucion.DetalleDevolucionRequestDTO;
import edu.bodega.yessy.back_sol.dto.detalledevolucion.DetalleDevolucionResponseDTO;
import edu.bodega.yessy.back_sol.services.DetalleDevolucionService;

@RestController
@RequestMapping("/detalledevoluciones")
public class DetalleDevolucionController {

    @Autowired
    private DetalleDevolucionService detalleDevolucionService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<DetalleDevolucionResponseDTO> listar() {
        return detalleDevolucionService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public DetalleDevolucionResponseDTO crear(@RequestBody DetalleDevolucionRequestDTO dto) {
        return detalleDevolucionService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public DetalleDevolucionResponseDTO buscar(@PathVariable Integer id) {
        return detalleDevolucionService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public DetalleDevolucionResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody DetalleDevolucionRequestDTO dto) {

        return detalleDevolucionService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleDevolucionService.eliminar(id);
    }
}