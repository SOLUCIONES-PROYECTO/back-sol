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

import edu.bodega.yessy.back_sol.dto.areausointerno.AreaUsoInternoRequestDTO;
import edu.bodega.yessy.back_sol.dto.areausointerno.AreaUsoInternoResponseDTO;
import edu.bodega.yessy.back_sol.services.AreaUsoInternoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/areausointernos")
public class AreaUsoInternoController {

    @Autowired
    private AreaUsoInternoService areaUsoInternoService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<AreaUsoInternoResponseDTO> listar() {
        return areaUsoInternoService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public AreaUsoInternoResponseDTO crear(@RequestBody AreaUsoInternoRequestDTO dto) {
        return areaUsoInternoService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public AreaUsoInternoResponseDTO buscar(@PathVariable Integer id) {
        return areaUsoInternoService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public AreaUsoInternoResponseDTO actualizar(
            @PathVariable Integer id,
            @RequestBody AreaUsoInternoRequestDTO dto) {

        return areaUsoInternoService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        areaUsoInternoService.eliminar(id);
    }
}
