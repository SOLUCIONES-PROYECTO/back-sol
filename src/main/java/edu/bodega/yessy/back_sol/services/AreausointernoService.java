package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.Areausointerno;
import edu.bodega.yessy.back_sol.repositories.AreausointernoRepository;

@Service
public class AreausointernoService {

    @Autowired
    AreausointernoRepository areausointernoRepository;

    public ArrayList<Areausointerno> listar() {
        return (ArrayList<Areausointerno>) areausointernoRepository.findAll();
    }

    public Areausointerno nuevo(Areausointerno areausointerno) {
        return areausointernoRepository.save(areausointerno);
    }
}
