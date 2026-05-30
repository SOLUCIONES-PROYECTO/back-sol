package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.DetalleMerma;
import edu.bodega.yessy.back_sol.repositories.DetalleMermaRepository;

@Service
public class DetalleMermaService {

    @Autowired
    DetalleMermaRepository detalleMermaRepository;

    public ArrayList<DetalleMerma> listar() {
        return (ArrayList<DetalleMerma>) detalleMermaRepository.findAll();
    }

    public DetalleMerma nuevo(DetalleMerma detalleMerma) {
        return detalleMermaRepository.save(detalleMerma);
    }
}
