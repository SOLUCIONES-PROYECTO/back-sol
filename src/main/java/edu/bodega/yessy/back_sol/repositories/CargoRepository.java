package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bodega.yessy.back_sol.models.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
