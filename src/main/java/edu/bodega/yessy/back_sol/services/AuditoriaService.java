package edu.bodega.yessy.back_sol.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.config.AuditoriaContext;
import edu.bodega.yessy.back_sol.models.Auditoria;
import edu.bodega.yessy.back_sol.repositories.AuditoriaRepository;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public void registrarAccion(String modulo, String accion, String detalle) {
        Auditoria auditoria = new Auditoria();
        auditoria.setUsuario(AuditoriaContext.getCurrentUser() != null ? AuditoriaContext.getCurrentUser() : "Sistema");
        auditoria.setModulo(modulo);
        auditoria.setAccion(accion);
        auditoria.setDetalle(detalle);
        auditoria.setFecha(LocalDateTime.now());
        
        auditoriaRepository.save(auditoria);
    }

    public List<Auditoria> listarTodos() {
        return auditoriaRepository.findAll(Sort.by(Sort.Direction.DESC, "fecha"));
    }
}
