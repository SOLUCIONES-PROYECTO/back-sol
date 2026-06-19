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

import edu.bodega.yessy.back_sol.dto.detallemerma.DetalleMermaRequestDTO;
import edu.bodega.yessy.back_sol.dto.detallemerma.DetalleMermaResponseDTO;
import edu.bodega.yessy.back_sol.services.DetalleMermaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detallemermas")
public class DetalleMermaController {

    @Autowired
    private DetalleMermaService detalleMermaService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<DetalleMermaResponseDTO> listar() {
        return detalleMermaService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public DetalleMermaResponseDTO crear(@RequestBody DetalleMermaRequestDTO dto) {
        return detalleMermaService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public DetalleMermaResponseDTO buscar(@PathVariable Integer id) {
        return detalleMermaService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public DetalleMermaResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody DetalleMermaRequestDTO dto) {

        return detalleMermaService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleMermaService.eliminar(id);
    }
}