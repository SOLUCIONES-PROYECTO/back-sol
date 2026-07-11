package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.dto.detalleusointerno.DetalleUsoInternoRequestDTO;
import edu.bodega.yessy.back_sol.dto.detalleusointerno.DetalleUsoInternoResponseDTO;
import edu.bodega.yessy.back_sol.services.DetalleUsoInternoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detalleusointernos")
public class DetalleUsoInternoController {

    @Autowired
    private DetalleUsoInternoService detalleUsoInternoService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<DetalleUsoInternoResponseDTO> listar() {
        return detalleUsoInternoService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public DetalleUsoInternoResponseDTO crear(@RequestBody DetalleUsoInternoRequestDTO dto) {
        return detalleUsoInternoService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public DetalleUsoInternoResponseDTO buscar(@PathVariable Integer id) {
        return detalleUsoInternoService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public DetalleUsoInternoResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody DetalleUsoInternoRequestDTO dto) {

        return detalleUsoInternoService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleUsoInternoService.eliminar(id);
    }
}