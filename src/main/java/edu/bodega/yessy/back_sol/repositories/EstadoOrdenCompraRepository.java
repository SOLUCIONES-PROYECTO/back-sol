package edu.bodega.yessy.back_sol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.EstadoOrdenCompra;

@Repository
public interface EstadoOrdenCompraRepository extends JpaRepository<EstadoOrdenCompra, Integer> {
    Optional<EstadoOrdenCompra> findByNombre(String nombre);
}
