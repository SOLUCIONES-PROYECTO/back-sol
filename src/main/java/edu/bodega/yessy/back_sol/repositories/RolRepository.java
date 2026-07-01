package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bodega.yessy.back_sol.models.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}