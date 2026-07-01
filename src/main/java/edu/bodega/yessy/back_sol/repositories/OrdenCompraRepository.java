package edu.bodega.yessy.back_sol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.OrdenCompra;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {
    List<OrdenCompra> findByEmpleado_Idempleado(Integer idEmpleado);
    List<OrdenCompra> findByProveedor_IdProveedor(Integer idProveedor);
    List<OrdenCompra> findByEstadoOc_IdestadoOc(Integer idEstado);
}