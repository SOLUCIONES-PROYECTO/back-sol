package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<Producto> listar() {
        return (ArrayList<Producto>) productoRepository.findAll();
    }

    public Producto nuevo(Producto producto) {
        return productoRepository.save(producto);
    }
}
