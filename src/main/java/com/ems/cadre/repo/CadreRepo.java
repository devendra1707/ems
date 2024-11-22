package com.ems.cadre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.cadre.model.Cadre;

@Repository
public interface CadreRepo extends JpaRepository<Cadre, Integer> {

}
