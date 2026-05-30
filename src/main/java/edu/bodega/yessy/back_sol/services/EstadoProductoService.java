package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.EstadoProducto;
import edu.bodega.yessy.back_sol.repositories.EstadoProductoRepository;

@Service
public class EstadoProductoService {

    @Autowired
    EstadoProductoRepository estadoProductoRepository;

    public ArrayList<EstadoProducto> listar() {
        return (ArrayList<EstadoProducto>) estadoProductoRepository.findAll();
    }

    public EstadoProducto nuevo(EstadoProducto estadoProducto) {
        return estadoProductoRepository.save(estadoProducto);
    }
}
