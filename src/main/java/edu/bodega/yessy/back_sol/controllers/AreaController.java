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

import edu.bodega.yessy.back_sol.dto.area.AreaRequestDTO;
import edu.bodega.yessy.back_sol.dto.area.AreaResponseDTO;
import edu.bodega.yessy.back_sol.services.AreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public ArrayList<AreaResponseDTO> listar() {
        return areaService.listar();
    }

    @PostMapping
    public AreaResponseDTO crear(@RequestBody AreaRequestDTO dto) {
        return areaService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public AreaResponseDTO buscar(@PathVariable Integer id) {
        return areaService.buscar(id);
    }

    @PutMapping("/{id}")
    public AreaResponseDTO actualizar(@PathVariable Integer id, @RequestBody AreaRequestDTO dto) {
        return areaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        areaService.eliminar(id);
    }
}
