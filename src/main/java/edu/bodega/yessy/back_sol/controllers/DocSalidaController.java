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

import edu.bodega.yessy.back_sol.dto.docsalida.DocSalidaRequest;
import edu.bodega.yessy.back_sol.dto.docsalida.DocSalidaResponseDTO;
import edu.bodega.yessy.back_sol.services.DocSalidaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/docsalida")
public class DocSalidaController {

    @Autowired
    private DocSalidaService docSalidaService;

    @GetMapping
    public ArrayList<DocSalidaResponseDTO> listarDocSalida() {
        return docSalidaService.listar();
    }

    @PostMapping
    public DocSalidaResponseDTO nuevoDocSalida(@RequestBody DocSalidaRequest dto) {
        return docSalidaService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public DocSalidaResponseDTO buscarDocSalida(@PathVariable Integer id) {
        return docSalidaService.buscar(id);
    }

    @PutMapping("/{id}")
    public DocSalidaResponseDTO actualizarDocSalida(
            @PathVariable Integer id,
            @RequestBody DocSalidaRequest dto) {

        return docSalidaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarDocSalida(@PathVariable Integer id) {
        docSalidaService.eliminar(id);
    }
}
