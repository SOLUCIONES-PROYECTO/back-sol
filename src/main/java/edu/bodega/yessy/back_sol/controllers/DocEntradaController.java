package edu.bodega.yessy.back_sol.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.DocEntrada;
import edu.bodega.yessy.back_sol.services.DocEntradaService;

@RestController
@RequestMapping("/docentrada")
public class DocEntradaController {

    @Autowired
    DocEntradaService docEntradaService;

    @GetMapping
    public ArrayList<DocEntrada> listarDocEntrada() {
        return docEntradaService.listar();
    }

    @PostMapping
    public DocEntrada nuevoDocEntrada(@RequestBody DocEntrada docEntrada) {
        return docEntradaService.nuevo(docEntrada);
    }
}
