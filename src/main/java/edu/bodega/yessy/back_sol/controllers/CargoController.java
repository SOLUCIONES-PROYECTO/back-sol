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

import edu.bodega.yessy.back_sol.dto.cargo.CargoRequestDTO;
import edu.bodega.yessy.back_sol.dto.cargo.CargoResponseDTO;
import edu.bodega.yessy.back_sol.services.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ArrayList<CargoResponseDTO> listar() {
        return cargoService.listar();
    }

    @PostMapping
    public CargoResponseDTO crear(@RequestBody CargoRequestDTO dto) {
        return cargoService.nuevo(dto);
    }

    @GetMapping("/{id}")
    public CargoResponseDTO buscar(@PathVariable Integer id) {
        return cargoService.buscar(id);
    }

    @PutMapping("/{id}")
    public CargoResponseDTO actualizar(@PathVariable Integer id, @RequestBody CargoRequestDTO dto) {
        return cargoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        cargoService.eliminar(id);
    }
}
