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

import edu.bodega.yessy.back_sol.dto.metodopago.MetodoPagoRequestDTO;
import edu.bodega.yessy.back_sol.dto.metodopago.MetodoPagoResponseDTO;
import edu.bodega.yessy.back_sol.services.MetodoPagoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/metodopagos")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<MetodoPagoResponseDTO> listar() {
        return metodoPagoService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public MetodoPagoResponseDTO crear(@RequestBody MetodoPagoRequestDTO dto) {
        return metodoPagoService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public MetodoPagoResponseDTO buscar(@PathVariable Integer id) {
        return metodoPagoService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public MetodoPagoResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody MetodoPagoRequestDTO dto) {

        return metodoPagoService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        metodoPagoService.eliminar(id);
    }
}