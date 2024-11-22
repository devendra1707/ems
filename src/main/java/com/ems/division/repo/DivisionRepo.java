package com.ems.division.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.division.model.Division;

public interface DivisionRepo extends JpaRepository<Division, Integer> {

}
