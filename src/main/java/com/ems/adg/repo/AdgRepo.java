package com.ems.adg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.adg.model.Adg;

@Repository
public interface AdgRepo extends JpaRepository<Adg, Integer> {

}
