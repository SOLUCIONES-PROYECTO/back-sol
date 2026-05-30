package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.UnidadMedida;
import edu.bodega.yessy.back_sol.repositories.UnidadMedidaRepository;

@Service
public class UnidadMedidaService {

    @Autowired
    UnidadMedidaRepository unidadMedidaRepository;

    public ArrayList<UnidadMedida> listar() {
        return (ArrayList<UnidadMedida>) unidadMedidaRepository.findAll();
    }

    public UnidadMedida nuevo(UnidadMedida unidadMedida) {
        return unidadMedidaRepository.save(unidadMedida);
    }
}
