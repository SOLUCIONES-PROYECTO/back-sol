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

import edu.bodega.yessy.back_sol.dto.rol.RolRequestDTO;
import edu.bodega.yessy.back_sol.dto.rol.RolResponseDTO;
import edu.bodega.yessy.back_sol.services.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ArrayList<RolResponseDTO> listar() {
        return rolService.listar();
    }

    @PostMapping
    public RolResponseDTO crear(@RequestBody RolRequestDTO dto) {
        return rolService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public RolResponseDTO buscar(@PathVariable Integer id) {
        return rolService.buscar(id);
    }

    @PutMapping("/{id}")
    public RolResponseDTO actualizar(@PathVariable Integer id, @RequestBody RolRequestDTO dto) {
        return rolService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        rolService.eliminar(id);
    }
}
