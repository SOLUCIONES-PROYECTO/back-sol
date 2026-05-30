package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.DetalleNea;
import edu.bodega.yessy.back_sol.repositories.DetalleNeaRepository;

@Service
public class DetalleNeaService {

    @Autowired
    DetalleNeaRepository detalleNeaRepository;

    public ArrayList<DetalleNea> listar() {
        return (ArrayList<DetalleNea>) detalleNeaRepository.findAll();
    }

    public DetalleNea nuevo(DetalleNea detalleNea) {
        return detalleNeaRepository.save(detalleNea);
    }
}
