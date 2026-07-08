package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.DocEntrada;

@Repository
public interface DocEntradaRepository extends JpaRepository<DocEntrada, Integer> {
    long countByTipoDocEntrada_Idtipodocentrada(Integer idTipoDocEntrada);
}
