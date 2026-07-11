package edu.bodega.yessy.back_sol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.EstadoIngreso;

@Repository
public interface EstadoIngresoRepository extends JpaRepository<EstadoIngreso, Integer> {
    Optional<EstadoIngreso> findByNombre(String nombre);
}
