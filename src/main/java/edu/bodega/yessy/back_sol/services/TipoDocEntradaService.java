package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.TipoDocEntrada;
import edu.bodega.yessy.back_sol.repositories.TipoDocEntradaRepository;

@Service
public class TipoDocEntradaService {

    @Autowired
    TipoDocEntradaRepository tipoDocEntradaRepository;

    public ArrayList<TipoDocEntrada> listar() {
        return (ArrayList<TipoDocEntrada>) tipoDocEntradaRepository.findAll();
    }

    public TipoDocEntrada nuevo(TipoDocEntrada tipoDocEntrada) {
        return tipoDocEntradaRepository.save(tipoDocEntrada);
    }
}
