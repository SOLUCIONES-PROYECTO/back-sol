package edu.bodega.yessy.back_sol.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.empleado.EmpleadoRequestDTO;
import edu.bodega.yessy.back_sol.dto.empleado.EmpleadoResponseDTO;
import edu.bodega.yessy.back_sol.services.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> listar() {
        return ResponseEntity.ok(
                empleadoService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                empleadoService.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> guardar(
            @RequestBody EmpleadoRequestDTO dto) {

        return ResponseEntity.ok(
                empleadoService.guardar(dto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizar(
            @PathVariable Integer id,
            @RequestBody EmpleadoRequestDTO dto) {

        return ResponseEntity.ok(
                empleadoService.actualizar(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id) {

        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}