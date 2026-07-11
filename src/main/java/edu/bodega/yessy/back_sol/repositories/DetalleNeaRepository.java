package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.DetalleNea;

@Repository
public interface DetalleNeaRepository extends JpaRepository<DetalleNea, Integer> {

}
