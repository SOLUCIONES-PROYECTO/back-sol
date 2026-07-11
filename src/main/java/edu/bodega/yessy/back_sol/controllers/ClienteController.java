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

import edu.bodega.yessy.back_sol.dto.cliente.ClienteRequestDTO;
import edu.bodega.yessy.back_sol.dto.cliente.ClienteResponseDTO;
import edu.bodega.yessy.back_sol.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ArrayList<ClienteResponseDTO> listarClientes() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscarCliente(
            @PathVariable Integer id) {

        return clienteService.buscar(id);
    }

    @PostMapping
    public ClienteResponseDTO nuevoCliente(
            @RequestBody ClienteRequestDTO dto) {

        return clienteService.nuevo(dto);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO actualizarCliente(
            @PathVariable Integer id,
            @RequestBody ClienteRequestDTO dto) {

        return clienteService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(
            @PathVariable Integer id) {

        clienteService.eliminar(id);
    }
}