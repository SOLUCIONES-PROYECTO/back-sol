package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.ordencompra.OrdenCompraRequest;
import edu.bodega.yessy.back_sol.dto.ordencompra.OrdenCompraResponse;
import edu.bodega.yessy.back_sol.services.OrdenCompraService;

@RestController
@RequestMapping("/ordenescompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public ArrayList<OrdenCompraResponse> listar() {
        return ordenCompraService.listar();
    }

    @GetMapping("/{id}")
    public OrdenCompraResponse buscar(@PathVariable Integer id) {
        return ordenCompraService.buscar(id);
    }

    @GetMapping("/empleado/{idEmpleado}")
    public ArrayList<OrdenCompraResponse> listarPorEmpleado(@PathVariable Integer idEmpleado) {
        return ordenCompraService.listarPorEmpleado(idEmpleado);
    }

    @GetMapping("/proveedor/{idProveedor}")
    public ArrayList<OrdenCompraResponse> listarPorProveedor(@PathVariable Integer idProveedor) {
        return ordenCompraService.listarPorProveedor(idProveedor);
    }

    @GetMapping("/estado/{idEstado}")
    public ArrayList<OrdenCompraResponse> listarPorEstado(@PathVariable Integer idEstado) {
        return ordenCompraService.listarPorEstado(idEstado);
    }

    @PostMapping
    public OrdenCompraResponse crear(@RequestBody OrdenCompraRequest dto) {
        return ordenCompraService.nuevo(dto);
    }

    @PatchMapping("/{id}/estado/{idNuevoEstado}")
    public OrdenCompraResponse cambiarEstado(
            @PathVariable Integer id,
            @PathVariable Integer idNuevoEstado) {
        return ordenCompraService.cambiarEstado(id, idNuevoEstado);
    }

    @DeleteMapping("/{id}/anular")
    public void anular(@PathVariable Integer id) {
        ordenCompraService.anular(id);
    }
}