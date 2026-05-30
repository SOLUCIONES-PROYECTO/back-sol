package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.DocSalida;
import edu.bodega.yessy.back_sol.repositories.DocSalidaRepository;

@Service
public class DocSalidaService {

    @Autowired
    DocSalidaRepository docSalidaRepository;

    public ArrayList<DocSalida> listar() {
        return (ArrayList<DocSalida>) docSalidaRepository.findAll();
    }

    public DocSalida nuevo(DocSalida docSalida) {
        return docSalidaRepository.save(docSalida);
    }
}
