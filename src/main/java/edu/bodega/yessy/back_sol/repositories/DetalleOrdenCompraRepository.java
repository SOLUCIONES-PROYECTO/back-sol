package edu.bodega.yessy.back_sol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.DetalleOrdenCompra;

@Repository
public interface DetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompra, Integer> {
    List<DetalleOrdenCompra> findByOrdenCompra_IdordenCompra(Integer idOrden);
}