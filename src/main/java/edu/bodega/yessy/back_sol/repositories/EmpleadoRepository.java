package edu.bodega.yessy.back_sol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Optional<Empleado> findByUsuarioSistema(String usuarioSistema);

    boolean existsByUsuarioSistema(String usuarioSistema);

    Optional<Empleado> findByPersonaCorreo(String correo);

    Optional<Empleado> findByResetToken(String resetToken);
}