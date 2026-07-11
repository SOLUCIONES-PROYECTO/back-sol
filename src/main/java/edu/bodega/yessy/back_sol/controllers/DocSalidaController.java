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

import edu.bodega.yessy.back_sol.dto.docsalida.DocSalidaRequest;
import edu.bodega.yessy.back_sol.dto.docsalida.DocSalidaResponseDTO;
import edu.bodega.yessy.back_sol.services.AuditoriaService;
import edu.bodega.yessy.back_sol.services.DocSalidaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/docsalida")
public class DocSalidaController {

    @Autowired
    private DocSalidaService docSalidaService;

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping
    public ArrayList<DocSalidaResponseDTO> listarDocSalida() {
        return docSalidaService.listar();
    }

    @PostMapping
    public DocSalidaResponseDTO nuevoDocSalida(@RequestBody DocSalidaRequest dto) {
        DocSalidaResponseDTO response = docSalidaService.nuevo(dto);
        auditoriaService.registrarAccion("Egresos", "CREAR", "Se registró el egreso");
        return response;
    }

    @GetMapping("/{id}")
    public DocSalidaResponseDTO buscarDocSalida(@PathVariable Integer id) {
        return docSalidaService.buscar(id);
    }

    @PutMapping("/{id}")
    public DocSalidaResponseDTO actualizarDocSalida(
            @PathVariable Integer id,
            @RequestBody DocSalidaRequest dto) {
        DocSalidaResponseDTO response = docSalidaService.actualizar(id, dto);
        auditoriaService.registrarAccion("Egresos", "ACTUALIZAR", "Se actualizó el egreso ID: " + id);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDocSalida(@PathVariable Integer id) {
        try {
            docSalidaService.eliminar(id);
            auditoriaService.registrarAccion("Egresos", "ELIMINAR", "Se eliminó el egreso ID: " + id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("mensaje", e.getMessage()));
        }
    }
}
