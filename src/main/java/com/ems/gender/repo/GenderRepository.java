package com.ems.gender.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.gender.model.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
