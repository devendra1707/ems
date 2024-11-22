package com.ems.gender.repo;

import org.springframework.data.repository.CrudRepository;

import com.ems.gender.model.Gender;

public interface GenderRepository extends CrudRepository<Gender, Integer> {

}
