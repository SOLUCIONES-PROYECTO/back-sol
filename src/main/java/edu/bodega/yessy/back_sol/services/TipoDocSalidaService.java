package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.TipoDocSalida;
import edu.bodega.yessy.back_sol.repositories.TipoDocSalidaRepository;

@Service
public class TipoDocSalidaService {

    @Autowired
    TipoDocSalidaRepository tipoDocSalidaRepository;

    public ArrayList<TipoDocSalida> listar() {
        return (ArrayList<TipoDocSalida>) tipoDocSalidaRepository.findAll();
    }

    public TipoDocSalida nuevo(TipoDocSalida tipoDocSalida) {
        return tipoDocSalidaRepository.save(tipoDocSalida);
    }
}
