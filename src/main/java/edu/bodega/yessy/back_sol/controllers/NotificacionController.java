package edu.bodega.yessy.back_sol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bodega.yessy.back_sol.dto.notificacion.NotificacionResponseDTO;
import edu.bodega.yessy.back_sol.services.NotificacionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<NotificacionResponseDTO> listarNotificaciones() {
        return notificacionService.obtenerAlertas();
    }
}
