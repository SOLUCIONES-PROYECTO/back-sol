package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.TipoDocEntrada;

@Repository
public interface TipoDocEntradaRepository extends JpaRepository<TipoDocEntrada, Integer> {

}
