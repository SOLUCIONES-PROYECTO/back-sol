package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.DetalleUsoInterno;
import edu.bodega.yessy.back_sol.repositories.DetalleUsoInternoRepository;

@Service
public class DetalleUsoInternoService {

    @Autowired
    DetalleUsoInternoRepository detalleUsoInternoRepository;

    public ArrayList<DetalleUsoInterno> listar() {
        return (ArrayList<DetalleUsoInterno>) detalleUsoInternoRepository.findAll();
    }

    public DetalleUsoInterno nuevo(DetalleUsoInterno detalleUsoInterno) {
        return detalleUsoInternoRepository.save(detalleUsoInterno);
    }
}
