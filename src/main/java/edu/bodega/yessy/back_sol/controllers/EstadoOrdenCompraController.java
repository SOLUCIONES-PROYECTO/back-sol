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

import edu.bodega.yessy.back_sol.dto.estadoordencompra.EstadoOrdenCompraRequest;
import edu.bodega.yessy.back_sol.dto.estadoordencompra.EstadoOrdenCompraResponse;
import edu.bodega.yessy.back_sol.services.EstadoOrdenCompraService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estadoordencompras")
public class EstadoOrdenCompraController {
    @Autowired
    private EstadoOrdenCompraService estadoOrdenCompraService;

    // ================= LISTAR =================
    @GetMapping
    public ArrayList<EstadoOrdenCompraResponse> listar() {
        return estadoOrdenCompraService.listar();
    }

    // ================= CREAR =================
    @PostMapping
    public EstadoOrdenCompraResponse crear(
            @RequestBody EstadoOrdenCompraRequest dto) {

        return estadoOrdenCompraService.nuevo(dto);
    }

    // ================= BUSCAR =================
    @GetMapping("/{id}")
    public EstadoOrdenCompraResponse buscar(
            @PathVariable Integer id) {

        return estadoOrdenCompraService.buscar(id);
    }

    // ================= ACTUALIZAR =================
    @PutMapping("/{id}")
    public EstadoOrdenCompraResponse actualizar(
            @PathVariable Integer id,
            @RequestBody EstadoOrdenCompraRequest dto) {

        return estadoOrdenCompraService.actualizar(id, dto);
    }

    // ================= ELIMINAR =================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        estadoOrdenCompraService.eliminar(id);
    }

}
