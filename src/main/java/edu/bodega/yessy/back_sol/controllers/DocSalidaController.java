package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.DocSalida;
import edu.bodega.yessy.back_sol.services.DocSalidaService;

@RestController
@RequestMapping("/docsalida")
public class DocSalidaController {

    @Autowired
    DocSalidaService docSalidaService;

    @GetMapping
    public ArrayList<DocSalida> listarDocSalida() {
        return docSalidaService.listar();
    }

    @PostMapping
    public DocSalida nuevoDocSalida(@RequestBody DocSalida docSalida) {
        return docSalidaService.nuevo(docSalida);
    }
}
