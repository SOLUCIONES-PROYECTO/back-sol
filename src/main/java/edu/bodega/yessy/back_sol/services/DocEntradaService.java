package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.DocEntrada;
import edu.bodega.yessy.back_sol.repositories.DocEntradaRepository;

@Service
public class DocEntradaService {

    @Autowired
    DocEntradaRepository docEntradaRepository;

    public ArrayList<DocEntrada> listar() {
        return (ArrayList<DocEntrada>) docEntradaRepository.findAll();
    }

    public DocEntrada nuevo(DocEntrada docEntrada) {
        return docEntradaRepository.save(docEntrada);
    }
}