package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.bodega.yessy.back_sol.models.AreaUsoInterno;
import edu.bodega.yessy.back_sol.repositories.AreaUsoInternoRepository;

@Service
public class AreaUsoInternoService {

    @Autowired
    AreaUsoInternoRepository areaUsoInternoRepository;

    public ArrayList<AreaUsoInterno> listar() {
        return (ArrayList<AreaUsoInterno>) areaUsoInternoRepository.findAll();
    }

    public AreaUsoInterno nuevo(AreaUsoInterno areaUsoInterno) {
        return areaUsoInternoRepository.save(areaUsoInterno);
    }
}
