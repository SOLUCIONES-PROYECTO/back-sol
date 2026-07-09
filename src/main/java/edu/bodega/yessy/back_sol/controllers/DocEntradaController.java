package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import edu.bodega.yessy.back_sol.dto.docentrada.DocEntradaRequestDTO;
import edu.bodega.yessy.back_sol.dto.docentrada.DocEntradaResponseDTO;
import edu.bodega.yessy.back_sol.services.DocEntradaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/docentrada")
public class DocEntradaController {

    @Autowired
    private DocEntradaService docEntradaService;

    @GetMapping
    public ArrayList<DocEntradaResponseDTO> listarDocEntrada() {
        return docEntradaService.listar();
    }

    @PostMapping
    public DocEntradaResponseDTO nuevoDocEntrada(@RequestBody DocEntradaRequestDTO dto) {
        return docEntradaService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public DocEntradaResponseDTO buscarDocEntrada(@PathVariable Integer id) {
        return docEntradaService.buscar(id);
    }

    @PutMapping("/{id}")
    public DocEntradaResponseDTO actualizarDocEntrada(
            @PathVariable Integer id,
            @RequestBody DocEntradaRequestDTO dto) {

        return docEntradaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDocEntrada(@PathVariable Integer id) {
        try {
            docEntradaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("mensaje", e.getMessage()));
        }
    }
}
