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

import edu.bodega.yessy.back_sol.dto.estadoingreso.EstadoIngresoRequestDTO;
import edu.bodega.yessy.back_sol.dto.estadoingreso.EstadoIngresoResponseDTO;
import edu.bodega.yessy.back_sol.services.EstadoIngresoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estadoingresos")
public class EstadoIngresoController {

    @Autowired
    private EstadoIngresoService estadoIngresoService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<EstadoIngresoResponseDTO> listar() {
        return estadoIngresoService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public EstadoIngresoResponseDTO crear(@RequestBody EstadoIngresoRequestDTO dto) {
        return estadoIngresoService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public EstadoIngresoResponseDTO buscar(@PathVariable Integer id) {
        return estadoIngresoService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public EstadoIngresoResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody EstadoIngresoRequestDTO dto) {

        return estadoIngresoService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        estadoIngresoService.eliminar(id);
    }
}