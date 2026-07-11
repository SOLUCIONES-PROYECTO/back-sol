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

import edu.bodega.yessy.back_sol.dto.proveedor.ProveedorRequestDTO;
import edu.bodega.yessy.back_sol.dto.proveedor.ProveedorResponseDTO;
import edu.bodega.yessy.back_sol.services.ProveedorService;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ArrayList<ProveedorResponseDTO> listarProveedores() {
        return proveedorService.listar();
    }

    @PostMapping
    public ProveedorResponseDTO nuevoProveedor(@RequestBody ProveedorRequestDTO dto) {
        return proveedorService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public ProveedorResponseDTO buscarProveedor(@PathVariable Integer id) {
        return proveedorService.buscar(id);
    }

    @PutMapping("/{id}")
    public ProveedorResponseDTO actualizarProveedor(
            @PathVariable Integer id,
            @RequestBody ProveedorRequestDTO dto) {

        return proveedorService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable Integer id) {
        proveedorService.eliminar(id);
    }
}
