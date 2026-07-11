package edu.bodega.yessy.back_sol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.DetalleEntrada;

@Repository
public interface DetalleEntradaRepository extends JpaRepository<DetalleEntrada, Integer> {
    List<DetalleEntrada> findByProducto_Idproducto(Integer idProducto);
}
