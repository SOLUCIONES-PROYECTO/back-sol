package edu.bodega.yessy.back_sol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bodega.yessy.back_sol.models.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {
}
