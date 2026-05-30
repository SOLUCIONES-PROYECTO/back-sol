package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.Proveedor;
import edu.bodega.yessy.back_sol.repositories.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public ArrayList<Proveedor> listar() {
        return (ArrayList<Proveedor>) proveedorRepository.findAll();
    }

    public Proveedor nuevo(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }
}
