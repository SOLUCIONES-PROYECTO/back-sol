package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.Cliente;
import edu.bodega.yessy.back_sol.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<Cliente> listar() {
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }

    public Cliente nuevo(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public boolean eliminar(Integer id) {
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Cliente actualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
