package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.bodega.yessy.back_sol.models.Cliente;
import edu.bodega.yessy.back_sol.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @GetMapping
    public ArrayList<Cliente> listarClientes() {
        return clienteService.listar();
    }
    @PostMapping
    public Cliente nuevoCliente(@RequestBody Cliente cliente) {
        return clienteService.nuevo(cliente);
    }
}