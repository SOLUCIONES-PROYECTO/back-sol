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

import edu.bodega.yessy.back_sol.models.Cliente;
import edu.bodega.yessy.back_sol.services.ClienteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cliente")
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
    @DeleteMapping("/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        boolean eliminado = clienteService.eliminar(id);
        if (eliminado) {
            return "Cliente eliminado correctamente";
        } else {
            return "No se pudo eliminar el cliente";
        }
    }
    @PutMapping
    public Cliente actualizarCliente(@RequestBody Cliente cliente) {
        return clienteService.actualizar(cliente);
    }
}