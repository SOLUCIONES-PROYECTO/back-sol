package edu.bodega.yessy.back_sol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.models.Auditoria;
import edu.bodega.yessy.back_sol.services.AuditoriaService;

@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping
    public List<Auditoria> listar() {
        return auditoriaService.listarTodos();
    }
}
