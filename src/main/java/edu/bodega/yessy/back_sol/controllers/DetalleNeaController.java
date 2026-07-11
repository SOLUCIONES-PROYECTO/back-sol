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

import edu.bodega.yessy.back_sol.dto.detallenea.DetalleNeaRequestDTO;
import edu.bodega.yessy.back_sol.dto.detallenea.DetalleNeaResponseDTO;
import edu.bodega.yessy.back_sol.services.DetalleNeaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detalleneas")
public class DetalleNeaController {

    @Autowired
    private DetalleNeaService detalleNeaService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<DetalleNeaResponseDTO> listar() {
        return detalleNeaService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public DetalleNeaResponseDTO crear(@RequestBody DetalleNeaRequestDTO dto) {
        return detalleNeaService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public DetalleNeaResponseDTO buscar(@PathVariable Integer id) {
        return detalleNeaService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public DetalleNeaResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody DetalleNeaRequestDTO dto) {

        return detalleNeaService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleNeaService.eliminar(id);
    }
}