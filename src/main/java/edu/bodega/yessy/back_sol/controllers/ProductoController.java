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

import edu.bodega.yessy.back_sol.dto.producto.ProductoRequestDTO;
import edu.bodega.yessy.back_sol.dto.producto.ProductoResponseDTO;
import edu.bodega.yessy.back_sol.services.ProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ArrayList<ProductoResponseDTO> listarProductos() {
        return productoService.listar();
    }

    @PostMapping
    public ProductoResponseDTO nuevoProducto(
            @RequestBody ProductoRequestDTO dto) {

        return productoService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO buscarProducto(
            @PathVariable Integer id) {

        return productoService.buscar(id);
    }

    @PutMapping("/{id}")
    public ProductoResponseDTO actualizarProducto(
            @PathVariable Integer id,
            @RequestBody ProductoRequestDTO dto) {

        return productoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        try {
            productoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("mensaje", e.getMessage()));
        }
    }

}