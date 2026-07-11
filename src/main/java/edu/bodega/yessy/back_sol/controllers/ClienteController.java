package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bodega.yessy.back_sol.dto.cliente.ClienteRequestDTO;
import edu.bodega.yessy.back_sol.dto.cliente.ClienteResponseDTO;
import edu.bodega.yessy.back_sol.services.AuditoriaService;
import edu.bodega.yessy.back_sol.services.ClienteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AuditoriaService auditoriaService;

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
        ClienteResponseDTO response = clienteService.nuevo(dto);
        auditoriaService.registrarAccion("Clientes", "CREAR", "Se registró el cliente con código: " + dto.getCodigoCliente());
        return response;
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO actualizarCliente(
            @PathVariable Integer id,
            @RequestBody ClienteRequestDTO dto) {
        ClienteResponseDTO response = clienteService.actualizar(id, dto);
        auditoriaService.registrarAccion("Clientes", "ACTUALIZAR", "Se actualizó el cliente ID: " + id);
        return response;
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(
            @PathVariable Integer id) {
        clienteService.eliminar(id);
        auditoriaService.registrarAccion("Clientes", "ELIMINAR", "Se eliminó el cliente ID: " + id);
    }
}