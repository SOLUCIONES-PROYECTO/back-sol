package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.DetalleSalida;
import edu.bodega.yessy.back_sol.repositories.DetalleSalidaRepository;

@Service
public class DetalleSalidaService {

    @Autowired
    DetalleSalidaRepository detalleSalidaRepository;

    public ArrayList<DetalleSalida> listar() {
        return (ArrayList<DetalleSalida>) detalleSalidaRepository.findAll();
    }

    public DetalleSalida nuevo(DetalleSalida detalleSalida) {
        return detalleSalidaRepository.save(detalleSalida);
    }
}