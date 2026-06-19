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

import edu.bodega.yessy.back_sol.dto.tipodocsalida.TipoDocSalidaRequestDTO;
import edu.bodega.yessy.back_sol.dto.tipodocsalida.TipoDocSalidaResponseDTO;
import edu.bodega.yessy.back_sol.services.TipoDocSalidaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipodocsalidas")
public class TipoDocSalidaController {

    @Autowired
    private TipoDocSalidaService tipoDocSalidaService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<TipoDocSalidaResponseDTO> listar() {
        return tipoDocSalidaService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public TipoDocSalidaResponseDTO crear(@RequestBody TipoDocSalidaRequestDTO dto) {
        return tipoDocSalidaService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public TipoDocSalidaResponseDTO buscar(@PathVariable Integer id) {
        return tipoDocSalidaService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public TipoDocSalidaResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody TipoDocSalidaRequestDTO dto) {

        return tipoDocSalidaService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        tipoDocSalidaService.eliminar(id);
    }
}