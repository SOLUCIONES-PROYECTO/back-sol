package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bodega.yessy.back_sol.models.DocSalida;

@Repository
public interface DocSalidaRepository extends JpaRepository<DocSalida, Integer> {
    long countByTipoDocSalida_Idtipodocsalida(Integer idTipoDocSalida);
}
