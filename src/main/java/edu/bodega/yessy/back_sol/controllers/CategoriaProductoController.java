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

import edu.bodega.yessy.back_sol.dto.categoriaproducto.CategoriaProductoRequestDTO;
import edu.bodega.yessy.back_sol.dto.categoriaproducto.CategoriaProductoResponseDTO;
import edu.bodega.yessy.back_sol.services.CategoriaProductoService;

@RestController
@RequestMapping("/categoriaproductos")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @GetMapping
    public ArrayList<CategoriaProductoResponseDTO> listar() {
        return categoriaProductoService.listar();
    }

    @PostMapping
    public CategoriaProductoResponseDTO crear(@RequestBody CategoriaProductoRequestDTO dto) {
        return categoriaProductoService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public CategoriaProductoResponseDTO buscar(@PathVariable Integer id) {
        return categoriaProductoService.buscar(id);
    }

    @PutMapping("/{id}")
    public CategoriaProductoResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody CategoriaProductoRequestDTO dto) {
        return categoriaProductoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        categoriaProductoService.eliminar(id);
    }
}
