package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.estadopago.EstadoPagoRequestDTO;
import edu.bodega.yessy.back_sol.dto.estadopago.EstadoPagoResponseDTO;
import edu.bodega.yessy.back_sol.services.EstadoPagoService;

@RestController
@RequestMapping("/estadopagos")
public class EstadoPagoController {

    @Autowired
    private EstadoPagoService estadoPagoService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<EstadoPagoResponseDTO> listar() {
        return estadoPagoService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public EstadoPagoResponseDTO crear(@RequestBody EstadoPagoRequestDTO dto) {
        return estadoPagoService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public EstadoPagoResponseDTO buscar(@PathVariable Integer id) {
        return estadoPagoService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public EstadoPagoResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody EstadoPagoRequestDTO dto) {

        return estadoPagoService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        estadoPagoService.eliminar(id);
    }
}