package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.bodega.yessy.back_sol.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
    boolean existsByDni(String dni);
    boolean existsByCorreo(String correo);
}

