package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.estadoproducto.EstadoProductoRequestDTO;
import edu.bodega.yessy.back_sol.dto.estadoproducto.EstadoProductoResponseDTO;
import edu.bodega.yessy.back_sol.services.EstadoProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estadoproductos")
public class EstadoProductoController {

    @Autowired
    private EstadoProductoService estadoProductoService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<EstadoProductoResponseDTO> listar() {
        return estadoProductoService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public EstadoProductoResponseDTO crear(@RequestBody EstadoProductoRequestDTO dto) {
        return estadoProductoService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public EstadoProductoResponseDTO buscar(@PathVariable Integer id) {
        return estadoProductoService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public EstadoProductoResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody EstadoProductoRequestDTO dto) {

        return estadoProductoService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    public void eliminar(@PathVariable Integer id) {
        estadoProductoService.eliminar(id);
    }
}