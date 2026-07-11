package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.DetalleUsoInterno;

@Repository
public interface DetalleUsoInternoRepository extends JpaRepository<DetalleUsoInterno, Integer> {

}
